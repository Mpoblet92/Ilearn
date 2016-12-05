package Controller;

import application.Main;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class newprofileController 
{
	//ObservableList<String> choiceMajorList = FXCollections
			//.observableArrayList("Computer Science", "Mathematics", "Physics", "Chemistry","Biology", "Accounting", "Nursing");
	ObservableList<String> choicePOSList = FXCollections
			.observableArrayList("B.S. Computer Science (Fall 2014)","B.S. Computer Science (Fall 2015)");
	
	@FXML private Button btnSave, btnBack;
	@FXML private TextField txtFirstName, txtLastName;
	@FXML private ChoiceBox<String> choiceMajorBox;
	@FXML private ChoiceBox<String> choicePOSBox;
	
	@FXML
	public void initialize() throws Exception
	{
		choiceMajorBox.setItems(FXCollections
				.observableArrayList("Computer Science");
		choicePOSBox.setItems(choicePOSList);
	}

	
	@FXML
	public void clickBack(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnBack.getScene().getWindow();
		stage.close();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void clickSave(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnSave.getScene().getWindow();
		stage.close();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}
