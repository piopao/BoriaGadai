package authorization;


import java.sql.Date;
import java.util.ArrayList;

public class User {
	/*userStatus: 0 - ordinary user; 1 - admin; */
	private int id, userStatus;
	private String username, hashPassword, email, name, surname, picture, info, gender;
	private ArrayList<Integer> friends; //stores ids
	private Date birthDate;
	
	
	public User(String email){
		this(null, null,  null, null, email, null, null, null, null);
	}
	
	public User( String username, String name, String surname, String hashPassword, String email, Date birthdate, String gender, String picture, String info){
		userStatus = 0;
		friends = new ArrayList<Integer>();
		setUsername(username);
		setName(name);
		setSurname(surname);
		setPictureDirname(picture);
		setBirthDate(birthdate);
		setInfo(info);
		setGender(gender);
		setEmail(email);
		setHashPassword(hashPassword);
	}	
	
	

	public void setHashPassword(String hashPassword){
		this.hashPassword = hashPassword;
	}
	
	public String getHashedPassword(){
		return hashPassword;
	}
	
	/*email setter/getters*/
	private void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	
	/*username setter/getters*/
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	
	/*name setter/getters*/
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}	
	
	
	
	/*surname setter/getters*/
	public void setSurname(String surname){
		this.surname = surname;
	}
	public String getSurname(){
		return this.surname;
	}	
	
	
	
	/*picture setter/getters*/
	public void setPictureDirname(String pictureDirname){
		this.picture = pictureDirname;
	}
	public String getPictureDirname(){
		return this.picture;
	}
	
	
	/*info setter/getters*/
	public void setInfo(String info){
		this.info = info;
	}
	public String getInfo(){
		return this.info;
	}
	
	
	/*sex setter/getters*/
	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}	
	
	/*friendlist setter/getters*/
	public void addFriend(int id){
		friends.add(Integer.valueOf(id));
	}
	
	public ArrayList<Integer> getFriends(){
		return friends;
	}
	
	public boolean hasFriend(int id){
		for(int i=0; i<friends.size(); i++){
			if(friends.get(i) == id) return true;
		}
		return false;
	}
	
	
	/*id setter/getters*/
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	
	/*userstatus setter/getters*/
	public void setUserStatus(int status){
		this.userStatus = status;
	}
	
	public int getUserStatus(){
		return this.userStatus;
	}	
	
	/*user birth date setter/getters*/
	public void setBirthDate(Date date){
		this.birthDate = date;
	}
	
	public Date getBirthDate(){
		return this.birthDate;
	}	
	
	
}
