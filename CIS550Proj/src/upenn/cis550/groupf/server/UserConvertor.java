package upenn.cis550.groupf.server;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;


import upenn.cis550.groupf.shared.User;
import upenn.cis550.groupf.shared.Board;

public class UserConvertor {
	/**
	 * This can only returns the first user in the set
	 * @param rs input ResultSet
	 * @return corresponding User object
	 * @throws SQLException
	 */
	public static User getUserFrom(ResultSet rs) {
		User user = null;
		try {
			rs.next();
			user = new User(rs.getInt("USERID"), rs.getString("NAME"),
					rs.getString("PASSWORD"), isMale(rs.getString("GENDER")),
					rs.getString("email"), rs.getString("phone"), 
					rs.getString("affiliation"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static Board getBoardFrom(ResultSet rs) throws SQLException {
		return new Board(rs.getInt("USERID"), rs.getInt("BOARDID"),
				rs.getString("BOARDNAME"));
		
	}
	
	
	/**
	 * This returns user and his/her Boards
	 * @param rs input ResultSet
	 * @return corresponding User object
	 * @throws SQLException
	 */
	public static Object getUserAndBoardFrom(ResultSet rs) {
		List<Object> userAndBoard = new ArrayList<Object>();
		User user = getUser(rs);
		userAndBoard.add(user);
		
		Board board = null;
		try {
			while(rs.next()){
				board = new Board(rs.getInt("USERID"), rs.getInt("BOARDID"),
						rs.getString("BOARDNAME"));
				userAndBoard.add(board);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userAndBoard;
	}
	

	// ATTENTION!! 
	// the only difference with getUserFrom is that this guy do not call rs.next().
	// it is called by getUserListFrom().
	// @author benwu
	public static User getUser(ResultSet rs) {
		User user = null;
		try {
			user = new User(rs.getInt("USERID"), rs.getString("NAME"),
					rs.getString("PASSWORD"), isMale(rs.getString("GENDER")),
					rs.getString("email"), rs.getString("phone"), 
					rs.getString("affiliation"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	private static boolean isMale(String gender) {
		return gender.equals("M");
	}

	/**
	 * reads a ResultSet stream and returns a list of User objects
	 * @param rs input ResultSet
	 * @return list of corresponding Users
	 * @throws SQLException 
	 */
	public static List<User> getUserListFrom(ResultSet rs) throws SQLException {
		List<User> ret = new ArrayList<User>();
		while (rs.next()) {
			ret.add(getUser(rs));
		}
		return ret;
	}
}
