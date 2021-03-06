package Fteller.db.managers;

import authorization.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import review.Review;

public class UserAccountManager {
	
	protected DataSource Source;

	public static final String ATTRIBUTE_NAME = "user_account_manager";

	protected enum MatchType {
		EXACT, LIKE
	};
	
	public UserAccountManager(DataSource Source) {
		this.Source = Source;
		// TODO Auto-generated constructor stub
	}

	public boolean checkEmail(String email) {
		try {
			Connection con = Source.getConnection();
			String query = "select * from users where email_address = \""+email +"\"";
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
		// password and email are mandatory fields
		if (user.getEmail() == null)
			return false;

		if (checkEmail(user.getEmail()))
			return false;

		// preparing insert values
		List<String> insertValues = new ArrayList<String>();
		fillWithUserData(insertValues, user);
		// registering account

		try {
			Connection con = Source.getConnection();
			/*
			 * String query =
			 * "INSERT INTO users VALUES ("+insertValues.get(0)+", \""+
			 * insertValues.get(1) +"\", \"" + insertValues.get(2)+"\", \""+
			 * insertValues.get(3)+"\", \""+ insertValues.get(4)+"\", \""+
			 * insertValues.get(5)+"\", "+ insertValues.get(6) +", \""+
			 * insertValues.get(7)+"\", \""+ insertValues.get(8)+"\", \""+
			 * insertValues.get(9)+"\", 0, 0)";
			 */

			String query = "INSERT INTO users VALUES (";
			if (!insertValues.isEmpty()) {
				for (int i = 0; i < insertValues.size(); ++i) {
					if (insertValues.get(i) != null)
						query = query + "\"" + insertValues.get(i) + "\"";
					else
						query = query + "null";
					query = query + ", ";
				}
			}
			query = query + "0, 0);";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	private void fillWithUserData(List<String> values, User user) {

		values.add(null);

		if (user.getUsername() != null)
			values.add(user.getUsername());
		else
			values.add(null);

		//
		if (user.getName() != null)
			values.add(user.getName());
		else
			values.add(null);

		//
		if (user.getSurname() != null)
			values.add(user.getSurname());
		else
			values.add(null);

		//
		if (user.getHashedPassword() != null)
			values.add(user.getHashedPassword());
		else
			values.add(null);

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
			String query = "select * from users where email_address = \""+email+"\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			// TODO: create user account;
			/**
			 * pink panthers todo list: todo todo todo todo todo todo todo todo
			 * todo todo
			 * 
			 */
			// TODO: done.
			if (rs.next())
				user = new User(rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
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

	public boolean isAdmin(String email) {
		try {
			Connection con = Source.getConnection();
			String query = "select * from admin where email = \"" + email +"\"";
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
		try {
			Connection con = Source.getConnection();
			String query = "delete from admin where email = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isBanned(String email) {
		try {
			Connection con = Source.getConnection();
			String query = "select * from banned_accounts where email = \""+email+"\"";
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

	public void banAccount(User user) {
		try {
			Connection con = Source.getConnection();
			String query = "insert into banned_accounts values  (\"" + user.getEmail() +"\")";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public void unbanAccount(User user) {
		try {
			Connection con = Source.getConnection();
			String query = "delete from banned_accounts where email = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeUserName(User user, String newUserName) {
		try {
			Connection con = Source.getConnection();
			String query = "update users set username=\""+ newUserName + "\"  where email_address = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeInfo(User user, String newInfo) {
		try {
			Connection con = Source.getConnection();
			String query = "update users set info=\""+ newInfo + "\"  where email_address = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeHashedPassword(User user, String newHashedPassword) {
		try {
			Connection con = Source.getConnection();
			String query = "update users set hashed_password=\""+ newHashedPassword + "\"  where email_address = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeLastName(User user, String newLastName) {
		// System.out.println(user.getEmail());
		try {
			Connection con = Source.getConnection();
			String query = "update users set user_surname=\""+ newLastName + "\"  where email_address = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeFirstName(User user, String newFirstName) {
		try {
			Connection con = Source.getConnection();
			String query = "update users set user_name=\""+ newFirstName + "\"  where email_address = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeBirthdate(User user, String newBirthdate) {
		try {
			Connection con = Source.getConnection();
			String query = "update users set birthdate=\""+ newBirthdate + "\"  where email_address = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeGender(User user, String newGender) {
		try {
			Connection con = Source.getConnection();
			String query = "update users set gender=\""+ newGender + "\"  where email_address = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeAvatarName(User user, String newAvatarName) {
		try {
			Connection con = Source.getConnection();
			String query = "update users set avatar_filename=\""+ newAvatarName + "\"  where email_address = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> checkPendingFriendRequests(String email) {

		ArrayList<String> initEmail = new ArrayList<String>();

		try {
			Connection con = Source.getConnection();

			String query = "select * from pending_friend_list where user_emailB = \""
					+ email + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next())
				initEmail.add(result.getString(1));
			con.close();

			return initEmail;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return initEmail;

	}

	public boolean sendFriendRequest(String initEmail, String receiverEmail) {
		try {
			Connection con = Source.getConnection();

			String queryCheck = "select * from pending_friend_list where user_emailA = \""+initEmail+"\"";
			PreparedStatement statementCheck = con.prepareStatement(queryCheck);
			ResultSet resultCheck = statementCheck.executeQuery();
			if (resultCheck.next())
				return false;

			String query = "insert into pending_friend_list values (\""
					+ initEmail + "\", \"" + receiverEmail + "\")";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return true;
	}

	public void acceptFriendRequest(String initEmail, String receiverEmail) {
		try {
			Connection con = Source.getConnection();
			String queryCheck = "delete from pending_friend_list where user_emailA = \""
					+ initEmail + "\"";
			PreparedStatement statementCheck = con.prepareStatement(queryCheck);
			int resultCheck = statementCheck.executeUpdate();

			String query = "insert into friend_list values (\"" + initEmail
					+ "\", \"" + receiverEmail + "\")";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			String queryTwo = "insert into friend_list values (\""
					+ receiverEmail + "\", \"" + initEmail + "\")";
			PreparedStatement statementTwo = con.prepareStatement(queryTwo);
			int resultTwo = statementTwo.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void declineFriendRequest(String initEmail, String receiverEmail) {
		try {
			Connection con = Source.getConnection();
			String queryCheck = "delete from pending_friend_list where user_emailA = \""
					+ initEmail + "\"";
			PreparedStatement statementCheck = con.prepareStatement(queryCheck);
			int resultCheck = statementCheck.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public boolean areFriends(String initEmail, String receiverEmail) {
		try {
			Connection con = Source.getConnection();
			String queryCheck = "select * from friend_list where user_emailA = \""
					+ initEmail + "\"";
			PreparedStatement statementCheck = con.prepareStatement(queryCheck);
			ResultSet resultCheck = statementCheck.executeQuery();
			if (resultCheck.next())
				if (receiverEmail.equals(resultCheck.getString(2)))
					return true;

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return false;
	}

	@SuppressWarnings("null")
	public ArrayList<String> getFriends(String email) {
		
		ArrayList<String> initEmail = new ArrayList<String>();

		try {
			Connection con = Source.getConnection();

			String query = "select * from friend_list where user_emailA = \"" + email +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next())
				initEmail.add(result.getString(2));
			con.close();

			return initEmail;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return initEmail;

	}

	// TODO: add after review class is created.

	public void deleteFriend(String initEmail, String receiverEmail) {
		try {
			Connection con = Source.getConnection();
			String queryCheck = "delete from pending_friend_list where user_emailA = \""
					+ initEmail + "\" AND \"" + receiverEmail + "\"";
			PreparedStatement statementCheck = con.prepareStatement(queryCheck);
			ResultSet resultCheck = statementCheck.executeQuery();

			String query = "delete from pending_friend_list where user_emailA = \""
					+ receiverEmail + "\" AND \"" + initEmail + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public double getUserRating(String email) {
		double rating = 0.0;
		try {
			Connection con = Source.getConnection();
			String query = "select rating from users where email_address=\""
					+ email + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next())
				rating = result.getDouble(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rating;
	}

	public ArrayList<String> getPopularFortuneTellers(int limit) {
		ArrayList<String> users = new ArrayList<String>();

		// select rating from users order by rating desc limit 20

		try {
			Connection con = Source.getConnection();
			String query = "select email_address from users order by rating desc limit "
					+ limit;
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next())
				users.add(result.getString(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;

	}

	public void removeAccount(User user) {
		try {
			Connection con = Source.getConnection();
			String query = "delete from users where email_address = \"" + user.getEmail() +"\"";
			PreparedStatement statement = con.prepareStatement(query);
			int result = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Review> getUserReviews(String email){
		ArrayList<Review> revs = new ArrayList<Review>();
		
		try {
			Connection con = Source.getConnection();

			String query = "select * from quiz_reviews where user_email = \""
					+ email + "\"";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()){
				Review rev = new Review(result.getString(6), result.getString(5), result.getString(2), result.getInt(3), result.getInt(1), result.getString(4));
				revs.add(rev);
				
				
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return revs;	
	}
	

}
