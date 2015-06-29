package weather;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import authorization.User;
import Fteller.db.managers.GameManager;	
import weather.WeatherServlet;
import static weather.WeatherConstants.*;
/**
 * Servlet implementation class WeatherGenerator
 */
@WebServlet("/WeatherGenerator")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user;
	private GameManager db;
	private HashMap<Integer, int[]> weatherMap;
	private HashMap<Integer, int[]> restrict;
	private ArrayList<Integer> generated;
	private Random rand;
	private Date date;
	private Calendar cal;
	private final int START_VALUE = WEATHER;
	private ArrayList<String> wForDB;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherServlet() {
        super();
       	date = new Date();
		cal = Calendar.getInstance();
		cal.setTime(date);
		CreateWeatherValues();
		CreateRestrictions();
    }
    
    public static void main(String[] args){
    	WeatherServlet w = new WeatherServlet();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
	    GameManager manager = (GameManager)context.getAttribute("GameManager");
	     System.out.print(manager);
		response.setCharacterEncoding("UTF-8");
		user =(User)request.getSession().getAttribute("user");
		PrintWriter out = response.getWriter();
		out.println(GenerateWeather());
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	
	//Main weather generator method
	public String GenerateWeather(){
		rand = new Random();
		String allreadyGenerated = db.checkTodaysWeather(user);
		if(allreadyGenerated.length() != 0){
			return allreadyGenerated;
		}
		generated = new ArrayList<Integer>();
		int month = cal.get(Calendar.MONTH);
		generated.add(month);
		int[] start = weatherMap.get(START_VALUE);
		for(int i=0; i<start.length; i++)
		GenerateRec(start[i]);		
		generated.add(GenerateTemperature());
		generated.remove(0);
		WeatherForDataBase();
		return db.getAndSaveWeather(null,wForDB);
	}
	
	private void WeatherForDataBase(){
		wForDB = new ArrayList<String>();
		wForDB.add(""+generated.get(0)+generated.get(1));
		wForDB.add(""+generated.get(2) +generated.get(3));
		wForDB.add(""+ generated.get(4));
	}

	//Recursively generates values of weather
	private boolean GenerateRec(int key){
		if(restrict.containsKey(key)){
			int[] restrictions = restrict.get(key);
			for(int i=0; i< restrictions.length; i++){
				if(generated.contains(restrictions[i])) return false;
			}				
		}
		if(!weatherMap.containsKey(key)){			
			generated.add(key);
			return true;
		}
		
		int[] values = weatherMap.get(key);
		boolean opposites = false;
	
		for(int i=0; i<values.length; i++){
			if(!weatherMap.containsKey(values[i])) opposites = true;
		}
		if(opposites){
			int n = rand.nextInt(values.length);
			while(!GenerateRec(values[n])){
				n = rand.nextInt(values.length);
			}
		}
		else{
			for(int i=0; i<values.length; i++){				
				GenerateRec(values[i]);
			}
		}		
		return true;
		
	}
	
	
	private int GenerateTemperature(){
		int month = cal.get(Calendar.MONTH);
		switch(month){
		case 1: case 2: case 12:
			return -5 + rand.nextInt(10);
		case 3: case 4: case 10:  
			return rand.nextInt(15);		
		case 5: case 9:
			return 18 + rand.nextInt(17);
		case 6: case 7: 
			return 20 + rand.nextInt(20);
		case 11:
			return rand.nextInt(10);
		}
		return -1;
		
	}	
	private void CreateRestrictions(){
		restrict = new HashMap<>();
		restrict.put(SUN, new int[]{RAIN_STRONG,RAIN_WEAK, RAIN_LIGHT,  SNOW_STRONG, SNOW_NORM});
		restrict.put(SUN_CLOUD, new int[]{RAIN_STRONG, SNOW_STRONG, SNOW_NORM});
		restrict.put(RAIN_STRONG, new int[]{SUN});
		restrict.put(RAIN_LIGHT,new int[]{SUN});	
		restrict.put(RAIN_WEAK,new int[]{SUN});	
		restrict.put(SNOW, new int[]{Calendar.MAY, Calendar.JUNE,Calendar.JULY,Calendar.AUGUST,Calendar.SEPTEMBER, Calendar.OCTOBER });
		restrict.put(SNOW_STRONG, new int[]{SUN, SUN_CLOUD});
		restrict.put(SNOW_NORM, new int[]{SUN, SUN_CLOUD});
	}
	
	
	private void CreateWeatherValues(){
		weatherMap = new HashMap<>();
		weatherMap.put(WEATHER, new int[]{SKY, SEDIMENT, WIND});
		weatherMap.put(SKY,new int[] {SUN, CLOUD, SUN_CLOUD});
		weatherMap.put(SEDIMENT,new int[]{RAIN, SNOW, ZERO});
		weatherMap.put(WIND,new int[]{W_STRENGTH, W_DIRECTION});
		weatherMap.put(W_STRENGTH, new int[]{WIND_STRONG, WIND_WEAK, WIND_NORM });
		weatherMap.put(W_DIRECTION, new int[]{WIND_DIR_W, WIND_DIR_E, WIND_DIR_E_S,WIND_DIR_E_N,WIND_DIR_W_N, WIND_DIR_W_S });
		weatherMap.put(RAIN, new int[]{RAIN_STRANGE, RAIN_WEAK, RAIN_STRONG, RAIN_LIGHT});	
		weatherMap.put(SNOW, new int[]{SNOW_STRONG, SNOW_WEAK, SNOW_NORM});
	}

}
