package upenn.cis550.groupf.client;

import java.sql.SQLException;

import upenn.cis550.groupf.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void validateUser(String name, String password, AsyncCallback<User> callback);

	void addUser(String firstName, String lastName, String email, String sex,
			AsyncCallback<User> callback);
	
	void retrieveUserInfo(String name, AsyncCallback<Object> callback);
}
