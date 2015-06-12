package reviews;

import java.util.Date;

public class Review {
	private int userID;
	private String mail, text;
	private Date date;

	public Review(int userID,String mail, String text, Date date){
		setMail(mail);
		setUserID(userID);
		setText(text);
		setDate(date);		
	}
	
	/*setters*/
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public void setUserID(int userID){
		this.userID = userID;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	/*getters*/
	public String getMail(){
		return this.mail;
	}
	
	public int getUserID(){
		return this.userID;
	}
	
	public String getText(){
		return this.text;
	}
	
	public Date getDate(){
		return this.date;
	}
	
}
