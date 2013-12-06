package upenn.cis550.groupf.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import upenn.cis550.groupf.client.event.ViewEvent;
import upenn.cis550.groupf.shared.User;
import upenn.cis550.groupf.shared.ViewResult;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class UserPage implements ViewEvent.Handler {
	
	public EventBus EVENT_BUS;
	private final ContentServiceAsync contentService = GWT
			.create(ContentService.class);
	
	final Label nameContent = new Label("");
	final Label affliationContent = new Label("");
	final Label lblEmailcontent = new Label("");
	
	public UserPage(EventBus bus, User user) {
		this.EVENT_BUS = bus;
		EVENT_BUS.addHandler(ViewEvent.TYPE, this);
		
		RootPanel rootPanel = RootPanel.get("loginPanel");
		rootPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		rootPanel.clear();
		
		// initialize layout
		HorizontalPanel contentPanel = new HorizontalPanel();
		contentPanel.setSize("900px", "500px");
		rootPanel.add(contentPanel);
		
		
		VerticalPanel personalInfoPanel = new VerticalPanel();
		personalInfoPanel.setStyleName("personal_panel");
		personalInfoPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		personalInfoPanel.setSize("200px", "551px");
		rootPanel.add(personalInfoPanel, 10, 20);
		
		VerticalPanel imagePanel = new VerticalPanel();
		imagePanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		personalInfoPanel.add(imagePanel);
		personalInfoPanel.setCellVerticalAlignment(imagePanel, HasVerticalAlignment.ALIGN_MIDDLE);
		personalInfoPanel.setCellHorizontalAlignment(imagePanel, HasHorizontalAlignment.ALIGN_CENTER);
		imagePanel.setSize("153px", "221px");
		
		Grid infoGrid = new Grid(3, 2);
		personalInfoPanel.add(infoGrid);
		infoGrid.setSize("151px", "143px");
		personalInfoPanel.setCellHorizontalAlignment(infoGrid, HasHorizontalAlignment.ALIGN_CENTER);
		
		Label lblName = new Label("Name");
		infoGrid.setWidget(0, 0, lblName);
		
		
		//infoGrid.setWidget(0, 1, nameContent);
		
		Label lblAffliation = new Label("Affliation");
		infoGrid.setWidget(1, 0, lblAffliation);
		
		
		//infoGrid.setWidget(1, 1, affliationContent);
		
		Label lblEmail = new Label("Email");
		infoGrid.setWidget(2, 0, lblEmail);
		
		
		Image defaultImage = new Image("/images/default.jpeg");
		defaultImage.setPixelSize(153, 143);
		lblName.setText(user.getName());
		affliationContent.setText(user.getAffiliation());
		lblEmailcontent.setText(user.getEmail());
		
		// add to conrresponding panels
		/**
		personalInfoPanel.add(defaultImage);
		personalInfoPanel.add(nameLabel);
		personalInfoPanel.add(birthdayLabel);
		personalInfoPanel.add(emailLabel);
		*/
		imagePanel.add(defaultImage);
		infoGrid.setWidget(0, 1, nameContent);
		infoGrid.setWidget(1, 1, affliationContent);
		infoGrid.setWidget(2, 1, lblEmailcontent);
		
		
		HorizontalPanel boardPanel = new HorizontalPanel();
		rootPanel.add(boardPanel, 210, 20);
		boardPanel.getElement().getStyle().setPosition(Position.RELATIVE);
		boardPanel.setSize("530px", "550px");
		
			
		
	}

	public void doWork() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserBoardFriends(int userID,
			AsyncCallback<ViewResult> callback) {
		// TODO Auto-generated method stub
		
	}
}
