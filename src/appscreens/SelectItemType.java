package appscreens;

import buttons.ExitButton;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SelectItemType extends Application{

	Stage stage = new Stage();
	
	//Containers
	BorderPane mainScreen = new BorderPane();
	
	HBox titleHolder = new HBox();
	HBox choiceBoxHolder = new HBox();
	HBox backButtonObject = new HBox();
	HBox nextScreenButtonObject = new HBox();
	HBox titleAndExitHolder = new HBox();
	
	//Text
	Text title = new Text("Please Select Item Type to Create");
	
	//Buttons
	ExitButton btnExit = new ExitButton(stage);
	//private Button btnNext = new Button("Next");
	private Button btnBack = new Button("Back");
	
	//ChoiceBox
	ChoiceBox<String> options = new ChoiceBox<>(FXCollections.observableArrayList("General","Music","Literature","Art"));
	
	//Constructor
	public SelectItemType() {
		addObjectsToContainers();
		makeButtonsWork();
		showApp();
	}
	
	//Methods

	private void addObjectsToContainers() {
		//Add everything to separate containers
		//nextScreenButtonObject.getChildren().add(btnNext);
		titleHolder.getChildren().add(title);
		choiceBoxHolder.getChildren().add(options);
		backButtonObject.getChildren().add(btnBack);
		
		//Add title and exit button to one container
		titleAndExitHolder.getChildren().addAll(titleHolder, btnExit);
		
		//Add everything to mainContainer
		mainScreen.setTop(titleAndExitHolder);		
		mainScreen.setCenter(choiceBoxHolder);
		mainScreen.setRight(nextScreenButtonObject);
		mainScreen.setLeft(backButtonObject);
	}
	
	private void makeButtonsWork() {
		backBtnListener();
		//nextBtnListener();		
	}
	
	//Listeners
	private void backBtnListener() {
		btnBack.setOnAction(e -> {
			goBackToHomeScreen();
		});
		
	}
	
	private void goBackToHomeScreen() {
		start(null);
		stage.close();
	}

	@Override
	public void start(Stage stage) {
		new HomeScreen();		
	}

	/* private void exitAppListener() {
		btnExit.setOnAction(e -> {
			exitApp();
		});
	}
	
	private void exitApp() {
		Platform.exit();
	} */
	
	private void showApp() {
		Scene scene = new Scene(mainScreen,950,750);	//first #: length, second #: height
		stage.setTitle("GYST");
		stage.setScene(scene);
		stage.show();		
	}
}
