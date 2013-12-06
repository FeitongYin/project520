package upenn.cis550.groupf.server;

import upenn.cis550.groupf.client.GreetingService;
import upenn.cis550.groupf.shared.FieldVerifier;
import upenn.cis550.groupf.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	static final String hostName = "cis550project.cwnynylpmg7r.us-west-2.rds.amazonaws.com";
	static final String user = "cis550project";
	static final String password = "cis550projectkey";
	static final String database = "PENNTR";

	Connection conn;
	Statement stat;
	
	public GreetingServiceImpl() {
		initDB();
	}

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	public void initDB() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//" + hostName
					+ "/" + database, user, password);

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public User validateUser(String name, String pw){
		ResultSet rs = null;
		
		try {
			stat = conn.createStatement();
	
			System.out.println("Validating Users...");
			rs = stat.executeQuery("SELECT * FROM Users where name = '"
					+ name + "' and password = '" + pw + "'");
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return UserConvertor.getUserFrom(rs);
	}

	@Override
	public User addUser(String firstName, String lastName, String email,
			String gender) {
		ResultSet rs = null;
		
		try {
			stat = conn.createStatement();
	
			System.out.println("Validating Users...");
//			rs = stat.executeQuery("insert into Users "
//					+ "(userID, name, password, gender, email) values (" + name + "' and password = '" + pw + "'");
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public User retrieveUserInfo(String name) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			
			System.out.println("Retrieving User's Information...");
			
			//rs = stat.executeQuery("SELECT * FROM Users where name = '"
				//	+ name +"'");
			rs = stat.executeQuery("SELECT U.*, B.boardID, B.boardName FROM Users U, Boards B where B.userID = U.userID and U.name = '"
						+ name +"'");
			
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return UserConvertor.getUserFrom(rs);
	}
	
	
}
