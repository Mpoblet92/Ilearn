package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class mainmenuController {

	@FXML private Button btnPoS, btnLogout, btnAdvisor, btnCourses, btnPref;
	
	@FXML
	public void clickAdvisor(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnAdvisor.getScene().getWindow();
		stage.close();
		advisorPage();
	}
	@FXML
	public void clickPlanofStudy(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnPoS.getScene().getWindow();
		stage.close();
		planOfStudyPage();
	}
	
	@FXML
	public void clickCourse(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnCourses.getScene().getWindow();
		stage.close();
		planOfStudyPage();
	}
	
	@FXML
	public void clickPreferences(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnPref.getScene().getWindow();
		stage.close();
		planOfStudyPage();
	}
	
	@FXML
	public void clickLogout(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnLogout.getScene().getWindow();
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
	
	public void planOfStudyPage() throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/PlanofStudy.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void advisorPage() throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/Advisor.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void preferencePage() throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/Preferences.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void coursePage() throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/Courses.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
