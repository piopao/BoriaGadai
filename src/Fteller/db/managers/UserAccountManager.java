package Fteller.db.managers;



import authorization.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class UserAccountManager extends DBManager{
	
	public static final String ATTRIBUTE_NAME = "user_account_manager";

	
	
	
	
	
	public UserAccountManager(DataSource Source) {
		super(Source);
		// TODO Auto-generated constructor stub
	}
	
	
	

	
public boolean checkEmail(String email) {
	try {
		Connection con = Source.getConnection();
		String query = generateSimpleSelectQuery("users",
				new ArrayList<String>(), "email_address", email);
		PreparedStatement statement = con.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		boolean contains = result.next();
		con.close();

		return contains;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}


public boolean createUserAccount(User user) {
	//password and email are mandatory fields
	if (user.getHashedPassword() == null
			|| user.getEmail() == null)
		return false;

	if (checkEmail(user.getEmail()))
		return false;

	// preparing insert values
	List<String> insertValues = new ArrayList<String>();
	fillWithUserData(insertValues, user);
	// registering account
	executeInsert("users", insertValues);

	return true;
}


private void fillWithUserData(List<String> values, User user) {
	
	values.add(null);
	
	
	if (user.getUsername() != null)
		values.add(user.getUsername());
	else
		values.add(null);
	values.add(user.getHashedPassword());
	values.add(user.getEmail());
	
	
	
	//
	if (user.getBirthDate() != null)
		values.add(user.getBirthDate().toString());
	else
		values.add(null);
	//
	if (user.getGender() != null)
		values.add(user.getGender());
	else
		values.add(null);
	//
	if (user.getPictureDirname() != null)
		values.add(user.getPictureDirname());
	else
		values.add(null);
	
	//
	if (user.getInfo() != null)
		values.add(user.getInfo());
	else
		values.add(null);

}


public User getUserAccount(String email) {
	User user = null;
	try {
		Connection con = Source.getConnection();
		String query = generateSimpleSelectQuery("users",
				new ArrayList<String>(), "email_address", email);
		PreparedStatement statement = con.prepareStatement(query);
		ResultSet rs = statement.executeQuery();

		//TODO: create user account;
		/**pink panthers todo list:
		 * todo
		 * todo
		 * todo todo todo todo todo todo todo todo
		 * 
		 */
		//TODO: done.
		user = new User(email);
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return user;
}


public List<User> getUserAccounts(int page, int limit) throws SQLException {
	List<User> userAccounts = new ArrayList<User>();
	Connection con = Source.getConnection();
	String query = "SELECT username FROM users LIMIT ?, ?;";
	PreparedStatement statement = con.prepareStatement(query);
	statement.setInt(1, (page - 1) * limit);
	statement.setInt(2, limit);
	ResultSet rs = statement.executeQuery();
	while (rs.next()) {
		User user = new User(rs.getString(1));
		userAccounts.add(user);
	}
	con.close();
	return userAccounts;
}


public int getUserAccountsQuantity() {
	int result = 0;
	try {
		Connection con = Source.getConnection();
		String query = "SELECT COUNT(email_address) FROM users";
		PreparedStatement statement = con.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		if (rs.next())
			result = rs.getInt(1);
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}


public boolean authenticateUser(String email, String hashedPassword) {
	User target = getUserAccount(email);
	if (target != null)
		return hashedPassword.equals(target.getHashedPassword());
	return false;
}


public boolean isAdmin(User user) {
	try {
		Connection con = Source.getConnection();
		String query = generateSimpleSelectQuery("admin",
				new ArrayList<String>(), "email_address", user.getEmail());
		PreparedStatement statement = con.prepareStatement(query);
		ResultSet result = statement.executeQuery();

		boolean isAdmin = result.next();
		con.close();

		return isAdmin;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}


public void removeAdmin(User user) {
	executeSimpleDelete("admin", "email_address", user.getEmail());
}


public boolean isBanned(User user) {
	try {
		Connection con = Source.getConnection();
		String query = generateSimpleSelectQuery("banned_accounts",
				new ArrayList<String>(), "email_address", user.getEmail());
		PreparedStatement statement = con.prepareStatement(query);
		ResultSet result = statement.executeQuery();

		boolean isBanned = result.next();
		con.close();

		return isBanned;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}


public boolean banAccount(User user) {
	String userEmail = user.getEmail();
	if (checkEmail(userEmail)) {
		List<String> values = new ArrayList<String>();
		values.add(userEmail);
		executeInsert("banned_accounts", values);
		return true;
	}
	return false;
}


public void unbanAccount(User user) {
	executeSimpleDelete("banned_accounts", "email_address", user.getEmail());
}


public void changeHashedPassword(User user, String newHashedPassword) {
	executeSimpleUpdate("users", "hashed_password", newHashedPassword,
			"email_address", user.getEmail());
}


public void changeEmail(User user, String newEmail) {
	executeSimpleUpdate("users", "email_address", newEmail, "email_address",
			user.getEmail());
}



public void changeBirthdate(User user, Date newBirthdate) {
	String birthday = null;
	if (newBirthdate != null)
		birthday = newBirthdate.toString();
	executeSimpleUpdate("users", "birthdate", birthday, "email_address",
			user.getEmail());
}


public void changeGender(User user, String newGender) {
	executeSimpleUpdate("users", "gender", newGender, "email_address",
			user.getEmail());
}




public void changeAvatarName(User user, String newAvatarName) {
	executeSimpleUpdate("users", "avatar_filename", newAvatarName,
			"user_id", user.getUsername());
}



//TODO: add after review class is created. 


/*
public List<Review> getReviews(User user, int page, int limit) {
	List<Review> reviews = new ArrayList<Review>();
	try {
		Connection con = Source.getConnection();
		StringBuilder builder = new StringBuilder("SELECT * FROM quiz_reviews ");
		builder.append("WHERE user_id = ? ");
		builder.append("ORDER BY review_date DESC ");
		builder.append("LIMIT ?, ? ;");
		PreparedStatement statement = con.prepareStatement(builder
				.toString());
		statement.setLong(1, user.getId());
		statement.setInt(2, (page - 1) * limit);
		statement.setInt(3, limit);
		ResultSet rs = statement.executeQuery();
		// building Review objects
		while (rs.next()) {
			String username = rs.getString(1);
			int game_id = rs.getInt(2);
			Integer rating = rs.getInt(3);
			String reviewText = rs.getString(4);
			Timestamp time = rs.getTimestamp(5);
			Review review = new Review(username, game_id, rating,
					reviewText, time);
			reviews.add(review);
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return reviews;
}
*/

public void removeAccount(User user) {
	executeSimpleDelete("users", "email_address", user.getEmail());
}

}

