package Fteller.db.managers;


//import review_dirName
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

	
	/**
	 * Constructor for UserAccountManager object with provided DataSource object.
	 * 
	 * @param Source
	 *            Source object representing connection pool.
	 */
	
	
	
	public UserAccountManager(DataSource Source) {
		super(Source);
		// TODO Auto-generated constructor stub
	}
	
	
	
/**
* checks if email is already used.
* 
* @param email
 *            User's unique email address.
* @return true if email address in not in the database, false otherwise.
*/
	
public boolean checkEmail(String email) {
	try {
		Connection con = Source.getConnection();
		String query = generateSimpleSelectQuery("users",
				new ArrayList<String>(), "email_adress", email);
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

/**
 * Creates account from given User object.
 * 
* @param user
 *            User account object.
 * @return true if the account creation is successful, false otherwise,
 *         namely, if any of the mandatory parameters is null or if user account
 *         with the same email already exists.
 */
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

/*
 * Fills List object with account data prior to insert into the database.
 */
private void fillWithUserData(List<String> values, User user) {
	values.add(user.getUsername());
	values.add(user.getHashedPassword());
	values.add(user.getEmail());
	if (user.getBirthDate() != null)
		values.add(user.getBirthDate().toString());
	else
		values.add(null);
	values.add(user.getGender());
	values.add(user.getPictureDirname());
}

/**
 * Returns User object by given email, assuming it is a unique user account
 * identifier.
 * 
 * @param email
 *            A unique user (account) identifier (ID).
 * @return user object if email was found, null otherwise.
 */
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
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return user;
}

/**
 * Returns the list of user accounts within the given range.
 * 
 * @param page
 *            The page the user is browsing.
 * @param limit
 *            The limit of results per page.
 * @return The list of users within the given range.
 * @throws SQLException
 */
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

/**
 * Returns the number of user accounts in database.
 * 
 * @return The number of user accounts in database.
 */
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

/**
 * Makes an user authentication attempt. Namely, checks if the given user
 * exists, if so, checks whether the password is correct.
 * 
 * @param email
 *            A unique user (account) identifier (ID).
 * @param hashedPassword
 *            Hashed password.
 * @return true if authentication was successful (user exists and password
 *         matches), false if account didn't exist or password was
 *         incorrect.
 */
public boolean authenticateUser(String email, String hashedPassword) {
	User target = getUserAccount(email);
	if (target != null)
		return hashedPassword.equals(target.getHashedPassword());
	return false;
}

/**
 * Checks whether the given account has administrator privileges.
 * 
* @param user
 *            User account object.
 * @return true if given account has administrator privileges, false
 *         otherwise.
 */
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

/**
 * Removes administrator based on given account.
 * 
* @param user
 *            User account object.
 */
public void removeAdmin(User user) {
	executeSimpleDelete("admin", "email_address", user.getEmail());
}

/**
 * Checks whether the given account is banned.
 * 
 * @param user
 *            User account object.
 * @return true if given account is banned, false otherwise.
 */
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

/**
 * Bans given account.
 * 
* @param user
 *            User account object.
 * @return true if account was successfully banned, false otherwise, namely,
 *         if account was not valid.
 */
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

/**
 * Removes ban from given account.
 * 
 * @param user
 *            User account object.
 */
public void unbanAccount(User user) {
	executeSimpleDelete("banned_accounts", "email_address", user.getEmail());
}

/**
 * Changes user account's password to the new one.
 * 
* @param user
 *            User account object.
 * @param newHashedPassword
 *            New (updated) hashed password.
 */
public void changeHashedPassword(User user, String newHashedPassword) {
	executeSimpleUpdate("users", "hashed_password", newHashedPassword,
			"email_address", user.getEmail());
}

/**
 * Changes user account's email address to the new one.
 * 
* @param user
 *            User account object.
 * @param newEmail
 *            New (updated) email address.
 */
public void changeEmail(User user, String newEmail) {
	executeSimpleUpdate("users", "email_address", newEmail, "email_address",
			user.getEmail());
}


/**
 * Changes user account's birthdate to the new one.
 * 
 * @param user
 *            User Account object.
 * @param newBirthdate
 *            New (updated) birthdate.
 */
public void changeBirthdate(User user, Date newBirthdate) {
	String birthday = null;
	if (newBirthdate != null)
		birthday = newBirthdate.toString();
	executeSimpleUpdate("users", "birthdate", birthday, "email_address",
			user.getEmail());
}

/**
 * Changes user account's gender to the new one.
 * 
 * @param user
 *            User Account object.
 * @param newGender
 *            New (updated) gender.
 */
public void changeGender(User user, String newGender) {
	executeSimpleUpdate("users", "gender", newGender, "email_address",
			user.getEmail());
}



/**
 * Changes user account's avatar filename to the new one.
 * 
 * @param user
 *            User Account object.
 * @param newAvatarName
 */
public void changeAvatarName(User user, String newAvatarName) {
	executeSimpleUpdate("users", "avatar_filename", newAvatarName,
			"user_id", user.getUsername());
}

/**
 * Returns the List of Review objects - all reviews associated with the
 * user.
 * 
 * @param user
 *            User Account object.
 * @param page
 *            The page user is on.
 * @param limit
 *            The limit of number of elements on single page.
 * @return The list of Review objects within the given range.
 */

//TODO: add after review class is created. 



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

/**
 * Permanently deletes User account.
 * 
 * @param user
 *            User account object.
 */
public void removeAccount(User user) {
	executeSimpleDelete("users", "email_adress", user.getEmail());
}

}

