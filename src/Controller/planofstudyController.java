package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.parser;
import application.IlearnDBConfig;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class planofstudyController {
	
	@FXML private Button btnBack;
	@FXML private Accordion listA, listB, listC, listD, listE, listF, listMajor, listMajorElective, listOther, listElective;
	private ArrayList<String> courseTaken = new ArrayList<String>();
	public void initialize() throws Exception
	{
		String major, pos, areaA = null, areaB = null, areaC = null, areaD = null, areaE = null, areaF = null, majorArea = null, majorElectives = null, otherArea = null, electives = null;
		String[] parsedAreaA, parsedAreaB, parsedAreaC, parsedAreaD, parsedAreaE, parsedAreaF, parsedMajorArea, parsedMajorElectives, parsedOther, parsedElectives;
		Connection con = IlearnDBConfig.getConnection();
		Statement stmt = con.createStatement();
		String getPlan = "select * from collegeplan";
		ResultSet rs = stmt.executeQuery(getPlan);
		while(rs.next())
		{
			major = rs.getString("major");
			pos = rs.getString("pos");
			areaA = rs.getString("AreaA");
			areaB = rs.getString("AreaB");
			areaC = rs.getString("AreaC");
			areaD = rs.getString("AreaD");
			areaE = rs.getString("AreaE");
			areaF = rs.getString("AreaF");
			majorArea = rs.getString("majorArea");
			majorElectives = rs.getString("majorElec");
			otherArea = rs.getString("areaOther");
			electives = rs.getString("electives");
		}
		con.close();
			parsedAreaA = parser.and(areaA);
			parsedAreaB = parser.and(areaB);
			parsedAreaC = parser.and(areaC);
			parsedAreaD = parser.and(areaD);
			parsedAreaE = parser.and(areaE);
			parsedAreaF = parser.and(areaF);
			parsedMajorArea = parser.and(majorArea);
			parsedMajorElectives = parser.and(majorElectives);
			parsedOther = parser.and(otherArea);
			parsedElectives = parser.and(electives);
			
			setTitlePane(listA, parsedAreaA);
			setTitlePane(listB, parsedAreaB);
			setTitlePane(listC, parsedAreaC);
			setTitlePane(listD, parsedAreaD);
			setTitlePane(listE, parsedAreaE);
			setTitlePane(listF, parsedAreaF);
			setTitlePane(listMajor, parsedMajorArea);
			setTitlePane(listOther, parsedOther);
			setTitlePane(listMajorElective, parsedMajorElectives);
			setTitlePane(listElective, parsedElectives);
		/*
		
		TextArea desc = new TextArea();
		TitledPane titleAreaA = new TitledPane("english", desc);
		listA.getPanes().addAll(titleAreaA);
	*/
	}
	
	public void setTitlePane(Accordion list, String[] parsedArea) throws Exception
	{
		for (int i = 0; i < parsedArea.length;i++)
		{
			if(parsedArea[i].contains(","))
			{
				String[] orClass = parser.or(parsedArea[i]);
				for(int o = 0; o < orClass.length; o++)
				{
					String[] course = getCourseInfo(orClass[o]); 
					TextArea desc = new TextArea();
					CheckBox taken = new CheckBox("Taken");
					VBox format = new VBox(desc, taken);
					TitledPane titleOrArea = new TitledPane(course[0], format);
					list.getPanes().addAll(titleOrArea);
					desc.setWrapText(true);
					desc.setText("Course ID: " + orClass[o] + "\n");
					desc.appendText("Description: " + course[1]);
					desc.setEditable(false);
					
				}
			}
			else
			{
				String[] course = getCourseInfo(parsedArea[i]); 
				TextArea desc = new TextArea();
				CheckBox taken = new CheckBox("Taken");
				VBox format = new VBox(desc, taken);
				TitledPane titleAndArea = new TitledPane(course[0], format);
				list.getPanes().addAll(titleAndArea);
				desc.setWrapText(true);
				desc.setText("Course ID: " + parsedArea[i] + "\n");
				desc.appendText("Description: " + course[1]);
				desc.setEditable(false);
				
			}
		}
	}
	
	public String[] getCourseInfo(String courseId) throws Exception
	{
		String[] course = new String[2];
		Connection con = IlearnDBConfig.getConnection();
		Statement stmt = con.createStatement();
		String getCourseInfo = "select courseName, courseDescription from course where courseId='" + courseId + "'";
		ResultSet r = stmt.executeQuery(getCourseInfo);
		while(r.next())
		{
			course[0] = r.getString("courseName");
			course[1] = r.getString("courseDescription");
		}
		con.close();
		return course;
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


}
