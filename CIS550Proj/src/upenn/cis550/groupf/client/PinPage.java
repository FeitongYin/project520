package upenn.cis550.groupf.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import upenn.cis550.groupf.client.event.ViewEvent;
import upenn.cis550.groupf.shared.User;
import upenn.cis550.groupf.shared.Board;
import upenn.cis550.groupf.shared.ViewResult;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.StackPanel;

public class PinPage implements ViewEvent.Handler {
	
	public EventBus EVENT_BUS;
	
	private final ContentServiceAsync contentService = GWT
			.create(ContentService.class);
	
	final Label idLabel = new Label();
	final Label nameLabel = new Label();
	final Label genderLabel = new Label();
	final Label emailLabel = new Label();
	final Label phoneLabel = new Label();
	final Label affiliationLabel = new Label();

	public PinPage(EventBus bus, User user) {
		this.EVENT_BUS = bus;
		EVENT_BUS.addHandler(ViewEvent.TYPE, this);
		
		List<Board> boards = null;
		List<User> friends = null;
		
		RootPanel rootPanel = RootPanel.get("loginPanel");
		rootPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		rootPanel.clear();
		
		HorizontalPanel mainPanel = new HorizontalPanel();
		mainPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		rootPanel.add(mainPanel, 10, 36);
		mainPanel.setSize("430px", "230px");
		
		StackPanel leftPanel = new LeftMenuPanel(user, boards, friends);
		mainPanel.add(leftPanel);
		leftPanel.setHeight("230px");
		
		VerticalPanel centerPanel = new VerticalPanel();
		centerPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		mainPanel.add(centerPanel);
		centerPanel.setSize("160px", "230px");
		
		VerticalPanel rightPanel = new VerticalPanel();
		rightPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		mainPanel.add(rightPanel);
		rightPanel.setSize("160px", "230px");
		
		HorizontalPanel topPanel = new TopPanel(user);
		topPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		rootPanel.add(topPanel, 10, 10);
		topPanel.setSize("430px", "20px");
		
		HorizontalPanel bottomPanel = new HorizontalPanel();
		bottomPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		rootPanel.add(bottomPanel, 10, 270);
		bottomPanel.setSize("430px", "20px");
		
		
		// for test only
		/*
		idLabel.setText(Integer.toString(user.getId()));
		nameLabel.setText(user.getName());
		genderLabel.setText((user.isMale() ? "M" : "F"));
		emailLabel.setText(user.getEmail());
		phoneLabel.setText(user.getPhone());
		affiliationLabel.setText(user.getAffiliation());
		
		leftPanel.add(idLabel);
		leftPanel.add(nameLabel);
		leftPanel.add(genderLabel);
		leftPanel.add(emailLabel);
		leftPanel.add(phoneLabel);
		leftPanel.add(affiliationLabel);
		*/
		
	}

	public void doWork() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserBoardFriends(int userID,
			AsyncCallback<ViewResult> callback) {
		contentService.getUserBoardFriends(userID, callback);
	}
}
