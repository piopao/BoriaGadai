package authorization;


import java.util.ArrayList;

public class User {
	/*userStatus: 0 - ordinary user; 1 - admin; */
	private int id, userStatus;
	private String username, hashPassword, email, name, surname, picture, info;
	private ArrayList<Integer> friends; //stores ids
	private int isMale;
	
	
	public User(String email){
		this(email, null, null, null, null, null, null, -1);
	}
	
	public User(String email, String username, String name, String surname, String picture, String info,  String hashPassword, int isMale){
		userStatus = 0;
		friends = new ArrayList<Integer>();
		setUsername(username);
		setName(name);
		setSurname(surname);
		setPicture(picture);
		setInfo(info);
		setSex(isMale);
		setEmail(email);
		setHashPassword(hashPassword);
	}	
	
	
	private void setHashPassword(String hashPassword){
		this.hashPassword = hashPassword;
	}
	
	private String getPassword(){
		return hashPassword;
	}
	
	/*email is immutable for the user*/
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
	public void setPicture(String picture){
		this.picture = picture;
	}
	public String getPicture(){
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
	public void setSex(int isMale){
		this.isMale = isMale;
	}

	public int getSex(){
		return isMale;
	}	
	
	/*friendlist setter/getters*/
	public void addFriend(int id){
		friends.add(Integer.valueOf(id));
	}
	
	public ArrayList<Integer> getFriends(){
		return friends;
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
	
	
	
}
