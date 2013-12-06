package upenn.cis550.groupf.client;

import upenn.cis550.groupf.shared.ViewResult;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface ContentService extends RemoteService {
	ViewResult getUserBoardFriends(int userID);
}
