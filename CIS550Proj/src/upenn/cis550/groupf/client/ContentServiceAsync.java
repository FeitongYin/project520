package upenn.cis550.groupf.client;

import upenn.cis550.groupf.shared.ViewResult;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface ContentServiceAsync {

	void getUserBoardFriends(int userID, AsyncCallback<ViewResult> callback);
}
