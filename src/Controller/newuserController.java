package Controller;

import java.lang.reflect.Array;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class newuserController {
	
	@FXML private Button btnCancel, btnSubmit;
	@FXML private PasswordField txtPassword, txtPasswordConfirm;
	@FXML private TextField txtUsername, txtEmail, txtEmailConfirm;
	@FXML private RadioButton radStudent, radAdvisor;
	@FXML private Label lblError;
	@FXML private Tooltip toolPassword;
	private String[] emailList = {"john@ung.edu", "jacob@ung.edu"};
	private String[] usernameList = {"john", "jacob"};
	

	@FXML
	public void clickCancel(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
		loginPage();
	}
	
	public void loginPage() throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/LoginView.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@FXML
	public void clickSubmit(ActionEvent event) throws Exception
	{
		
		
		int pwd = passwordCheck();
		int email = emailCheck();
		int user = usernameCheck();

		switch (pwd) {
		case 0: 
		break;
		case 1: lblError.setText("Empty Password Field");
		break;
		case 2: lblError.setText("Empty Confirm Password Field");
		break;
		case 3:
				lblError.setText("Password Requirements Not Met!");
		break;
		case 4: lblError.setText("Passwords do not match");
	    break;
		}
		
		switch (email) {
		case 0: 
		break;
		case 1: lblError.setText("Empty Email Field");
		break;
		case 2: lblError.setText("Empty Confirm Email Field");
		break;
		case 3:
				lblError.setText("Must be a valid UNG Email");
		break;
		case 4: lblError.setText("Emails do not match");
	    break;
		case 5: lblError.setText("Email is in use");
		break;
		}
		
		switch (user) {
		case 0: 
		break;
		case 1: lblError.setText("Empty Username Field");
		break;
		case 2: lblError.setText("Username is in use");
		break;
		}
		
		if(pwd  + email + user == 0){
			//Stage stage = (Stage) btnCancel.getScene().getWindow();
			//profilePage();
			txtPassword.setText("");
			txtPasswordConfirm.setText("");
			txtEmail.setText("");
			txtEmailConfirm.setText("");
			txtUsername.setText("");
			lblError.setText("Account Succesfully Created!");
		}
			
	}
	
	public void profilePage() throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/LoginView.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private int passwordCheck() throws Exception
	{
		if(txtPassword.getText().equals(""))
		{
			return 1;
		} 
		else if(txtPasswordConfirm.getText().equals("")) 
		{
			return 2;
		} 
		else if(!checkPassword(txtPassword.getText()))
		{
			
			return 3;
		}
		else if(!txtPassword.getText().equals(txtPasswordConfirm.getText())) {
			return 4;
		} 
		else 
		{
			return 0;
		}

	}
	
	private int usernameCheck() throws Exception
	{
		if(txtUsername.getText().equals(""))
		{
			return 1;
		} else {
			for(int i = 0; i < usernameList.length; i++)
			{
				if (txtUsername.getText().equals(usernameList[i].toString()))
					return 2;
			}
		}
		return 0;
	}
	
	private int emailCheck() throws Exception
	{
		if(txtEmail.getText().equals(""))
			return 1;
		else if(txtEmailConfirm.getText().equals(""))
			return 2;
		else if(!checkEmail(txtEmail.getText()))
			return 3;
		else if(!txtEmail.getText().equals(txtEmailConfirm.getText()))
			return 4;
		else {
			for(int i = 0; i < emailList.length; i++)
			{
				if (txtEmail.getText().equals(emailList[i].toString()))
					return 5;
			}
		}
		return 0;
	}
	
	public boolean checkPassword(String value){
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		return value.matches(pattern);
		}
	public boolean checkEmail(String value)
	{
		String pattern = "\\b^[A-Za-z][A-Za-z][A-Za-z][a-z]*\\d{4}(@ung[.]edu$)\\b";
		return value.matches(pattern);
	}
	
	public void setTooltip()
	{
		toolPassword.setText("Must be alteast 8 characters\n" +
								"Must contain atleast one uppercase\n" +
								"Must contain atleast one lowercase letter\n" +
								"Must contain atleast one special character\n" +
								"Must contain atleast one number");
	}
}
