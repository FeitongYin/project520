package upenn.cis550.groupf.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Register extends Composite {

	public Register() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setBorderWidth(0);
		initWidget(verticalPanel);
		verticalPanel.setSize("720px", "571px");
		
		HorizontalPanel horizontalPanelLogo = new HorizontalPanel();
		horizontalPanelLogo.setStyleName("gwt-Logo");
		verticalPanel.add(horizontalPanelLogo);
		horizontalPanelLogo.setSize("720px", "80px");
		
		Grid gridLogo = new Grid(1, 1);
		horizontalPanelLogo.add(gridLogo);
		
		Label LabelPennterest = new Label("Pennterest");
		LabelPennterest.setStyleName("gwt-LableLogo");
		gridLogo.setWidget(0, 0, LabelPennterest);
		LabelPennterest.setHeight("80px");
		
		Button ButtonBackToSignIn = new Button("New button");
		ButtonBackToSignIn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});
		ButtonBackToSignIn.setStyleName("gwt-ButtonBackToSignIn");
		ButtonBackToSignIn.setText("Log in to existing account");
		horizontalPanelLogo.add(ButtonBackToSignIn);
		ButtonBackToSignIn.setSize("210px", "30px");
		horizontalPanelLogo.setCellHorizontalAlignment(ButtonBackToSignIn, HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanelLogo.setCellVerticalAlignment(ButtonBackToSignIn, HasVerticalAlignment.ALIGN_MIDDLE);
		
		Label LabelSignUp = new Label("Sign Up");
		LabelSignUp.setStyleName("gwt-LabelSignUp");
		verticalPanel.add(LabelSignUp);
		LabelSignUp.setHeight("62px");
		verticalPanel.setCellHorizontalAlignment(LabelSignUp, HasHorizontalAlignment.ALIGN_CENTER);
		
		Grid gridUserName = new Grid(1, 2);
		gridUserName.setCellSpacing(2);
		verticalPanel.add(gridUserName);
		verticalPanel.setCellHorizontalAlignment(gridUserName, HasHorizontalAlignment.ALIGN_CENTER);
		
		TextBox textBoxFirstname = new TextBox();
		gridUserName.setWidget(0, 0, textBoxFirstname);
		textBoxFirstname.setAlignment(TextAlignment.LEFT);
		textBoxFirstname.setStyleName("gwt-TextBoxUserName");
		textBoxFirstname.setText("First Name");
		textBoxFirstname.setSize("130px", "30px");
		
		TextBox textBoxLastName = new TextBox();
		gridUserName.setWidget(0, 1, textBoxLastName);
		textBoxLastName.setStyleName("gwt-TextBoxUserName");
		textBoxLastName.setText("Last Name");
		textBoxLastName.setSize("130px", "30px");
		
		TextBox textBoxEmail = new TextBox();
		textBoxEmail.setStyleName("gwt-TextBoxEmail");
		verticalPanel.add(textBoxEmail);
		verticalPanel.setCellHorizontalAlignment(textBoxEmail, HasHorizontalAlignment.ALIGN_CENTER);
		textBoxEmail.setText("Your Email");
		textBoxEmail.setSize("273px", "30px");
		
		TextBox textBoxReenterEmail = new TextBox();
		textBoxReenterEmail.setText("Re-enter Email");
		textBoxReenterEmail.setStyleName("gwt-TextBoxEmail");
		verticalPanel.add(textBoxReenterEmail);
		verticalPanel.setCellHorizontalAlignment(textBoxReenterEmail, HasHorizontalAlignment.ALIGN_CENTER);
		textBoxReenterEmail.setSize("273px", "30px");
		
		PasswordTextBox textBoxPassword = new PasswordTextBox();
		textBoxPassword.setText("New Password");
		textBoxPassword.setStyleName("gwt-TextBoxPassword");
		verticalPanel.add(textBoxPassword);
		verticalPanel.setCellHorizontalAlignment(textBoxPassword, HasHorizontalAlignment.ALIGN_CENTER);
		textBoxPassword.setSize("270px", "30px");
		
		Label LabelBirtyday = new Label("Birthday");
		LabelBirtyday.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		LabelBirtyday.setStyleName("gwt-LabelBirthday");
		verticalPanel.add(LabelBirtyday);
		verticalPanel.setCellHorizontalAlignment(LabelBirtyday, HasHorizontalAlignment.ALIGN_CENTER);
		LabelBirtyday.setSize("270px", "25px");
		
		Grid gridBirthday = new Grid(1, 3);
		verticalPanel.add(gridBirthday);
		gridBirthday.setWidth("270px");
		verticalPanel.setCellHorizontalAlignment(gridBirthday, HasHorizontalAlignment.ALIGN_CENTER);
		
		ListBox comboBoxBirthdayMonth = new ListBox();
		comboBoxBirthdayMonth.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});
		gridBirthday.setWidget(0, 0, comboBoxBirthdayMonth);
		comboBoxBirthdayMonth.setWidth("75px");
		gridBirthday.getCellFormatter().setWidth(0, 0, "80");
		
		ListBox comboBoxBirthdayDay = new ListBox();
		comboBoxBirthdayDay.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});
		gridBirthday.setWidget(0, 1, comboBoxBirthdayDay);
		gridBirthday.getCellFormatter().setWidth(0, 1, "80px");
		comboBoxBirthdayDay.setWidth("75px");
		
		ListBox listBox = new ListBox();
		listBox.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});
		gridBirthday.setWidget(0, 2, listBox);
		gridBirthday.getCellFormatter().setWidth(0, 2, "80px");
		listBox.setWidth("75px");
		
		Grid gridSex = new Grid(1, 2);
		verticalPanel.add(gridSex);
		verticalPanel.setCellHorizontalAlignment(gridSex, HasHorizontalAlignment.ALIGN_CENTER);
		gridSex.setWidth("270px");
		verticalPanel.setCellWidth(gridSex, "270px");
		
		RadioButton RadioButtonFemale = new RadioButton("new name", "Female");
		RadioButtonFemale.setStyleName("gwt-RadioButtonGender");
		gridSex.setWidget(0, 0, RadioButtonFemale);
		gridSex.getCellFormatter().setWidth(0, 0, "80px");
		RadioButtonFemale.setWidth("88px");
		
		RadioButton RadioButtonMale = new RadioButton("new name", "Male");
		RadioButtonMale.setStyleName("gwt-RadioButtonGender");
		gridSex.setWidget(0, 1, RadioButtonMale);
		gridSex.getCellFormatter().setWidth(0, 1, "");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.setWidth("270px");
		
		Button ButtonSignUp = new Button("New button");
		ButtonSignUp.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
			}
		});
		ButtonSignUp.setStyleName("gwt-ButtonSignUp");
		ButtonSignUp.setText("Sign Up");
		horizontalPanel.add(ButtonSignUp);
		ButtonSignUp.setSize("170px", "40px");
	}

}
