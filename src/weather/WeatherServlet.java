package weather;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weather.DBManager;
import weather.WeatherServlet;

/**
 * Servlet implementation class WeatherGenerator
 */
@WebServlet("/WeatherGenerator")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int userId;
	private DBManager db;
	private HashMap<String, String[]> weatherMap;
	private HashMap<String, String[]> restrict;
	private ArrayList<String> finalWeather;
	private Random rand;
	private Date date;
	private Calendar cal;
	private final String START_STRING = "amindi";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherServlet() {
        super();
        this.userId = 4;
		db = new DBManager();
		date = new Date();
		cal = Calendar.getInstance();
		cal.setTime(date);
		CreateWeatherValues();
		CreateRestrictions();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println(GenerateWeather());
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public static void main(String[] args){
		WeatherServlet w = new WeatherServlet();
		for (int i=0; i<2; i++)
		System.out.print(w.GenerateWeather() + "\n");
	}
	
	//Main weather generator method
	public String GenerateWeather(){
		rand = new Random();
		String allreadyGenerated = db.TodaysWeather(userId);
		if(allreadyGenerated.length() != 0){
			return allreadyGenerated;
		}
		finalWeather = new ArrayList<String>();
		int month = cal.get(Calendar.MONTH);
		finalWeather.add(""+month);
		String[] start = weatherMap.get(START_STRING);
		for(int i=0; i<start.length; i++){
			GenerateRec(start[i]);
		}
		finalWeather.add(""+GenerateTemperature());
		finalWeather.remove(0);
		
		return db.GetWeather(finalWeather);
	}
	
	//Recursively generates values of weather
	private boolean GenerateRec(String key){
		if(key.equals("-")) return true;
		if(restrict.containsKey(key)){
			String[] restrictions = restrict.get(key);
			for(int i=0; i< restrictions.length; i++){
				if(finalWeather.contains(restrictions[i])) return false;
			}				
		}
		if(!weatherMap.containsKey(key)){			
			finalWeather.add(key);
			return true;
		}
		
		String[] values = weatherMap.get(key);
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
	private void CreateWeatherValues(){
		weatherMap = new HashMap<>();
		weatherMap.put("amindi", new String[]{"ca", "qari", "naleqi"});
		weatherMap.put("ca", new String[] {"mze", "ghrubeli"});
		weatherMap.put("qari",new String[]{"qari-ki", "-"}); 
		weatherMap.put("naleqi",new String[]{"wvima", "tovli", "-"});
		weatherMap.put("qari-ki",new String[]{"dzala", "mimartuleba"});
		weatherMap.put("dzala", new String[]{"qarbuqi", "susti qari", "sashualo qari" });
		weatherMap.put("mimartuleba", new String[]{"dasavletidan qari", "aghmosavletidan qari", "dasavlet-chrdiloetidan qari","dasavlet-samxretidan qari", "aghmosavlet-chrdiloetidan qari", "aghmosavlet-samxretidan qari" });
		weatherMap.put("wvima", new String[]{"jujuna wvima", "susti wvima", "kokispiruli wvima", "elweqit wvima"});	
		weatherMap.put("tovli", new String[]{"dzlieri tova", "suti tova", "tova"});
	}

	private void CreateRestrictions(){
		restrict = new HashMap<>();
		restrict.put("mze", new String[]{"kokispiruli wvima", "elweqit wvima",  "dzlieri tova", "tova"});
		restrict.put("kokispiruli wvima", new String[]{"mze"});
		restrict.put("elweqit wvima", new String[]{"mze"});		
		restrict.put("tovli", new String[]{""+Calendar.MAY,  ""+Calendar.JUNE,""+Calendar.JULY, ""+Calendar.AUGUST, ""+Calendar.SEPTEMBER, ""+Calendar.OCTOBER });
		restrict.put("dzlieri tova", new String[]{"mze"});
		restrict.put("tova", new String[]{"mze"});
	}
	

}
