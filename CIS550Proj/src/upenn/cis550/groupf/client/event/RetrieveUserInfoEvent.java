package upenn.cis550.groupf.client.event;

import upenn.cis550.groupf.shared.User;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * This represents an event to be passed along the EventBus.
 * It is used to retrieve user's information.
 * 
 * @author FeitongYin
 *
 */

public class RetrieveUserInfoEvent extends GwtEvent<RetrieveUserInfoEvent.Handler> {
	
	private String name;
		
	// Whom to call when results are returned
	private AsyncCallback<User> callback; 
		
	/**
	 * GwtEvents need to make clear what their type and handler type is
	 */
	public static Type<RetrieveUserInfoEvent.Handler> TYPE = 
			new Type<RetrieveUserInfoEvent.Handler>();
	
	
	public RetrieveUserInfoEvent(String name, AsyncCallback<User> callback) {
		this.name = name;
		this.callback = callback;
	}
	
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
		return TYPE;
	}


	@Override
	protected void dispatch(Handler handler) {
		// TODO Auto-generated method stub
		handler.processRetrieve(name, callback);
		
	}
	/**
	 * An event handler for the query request event
	 * 
	 * @author zives
	 *
	 */
	public static interface Handler extends EventHandler {
		public void processRetrieve(String name, 
				AsyncCallback<User> callback);
	}

}
