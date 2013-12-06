package upenn.cis550.groupf.server;

import upenn.cis550.groupf.client.ContentService;
import upenn.cis550.groupf.shared.ViewResult;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ContentServiceImpl extends RemoteServiceServlet implements
		ContentService {

	@Override
	public ViewResult getUserBoardFriends(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
