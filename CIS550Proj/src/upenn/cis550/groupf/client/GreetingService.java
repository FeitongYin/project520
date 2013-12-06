package upenn.cis550.groupf.client;

import java.util.List;

import upenn.cis550.groupf.shared.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	User validateUser(String name, String password);
	
	User addUser(String firstName, String lastName, String email, String sex);
	
	List<Object> retrieveUserInfo(String name);
}
