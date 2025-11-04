package appscreens;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeScreen {
	
	//Containers
	BorderPane mainContainer = new BorderPane();
	
	HBox titleHolder = new HBox();
	HBox taglineHolder = new HBox();
	HBox startButtonOrCreateNewItemObject = new HBox();
	HBox goToCollectionButtonObject = new HBox();
	HBox exitButtonObject = new HBox();
	
	VBox everythingButExit = new VBox();
	
	
	//Text
	Text title = new Text("G.Y.S.T");
	Text tagline = new Text("Get Your Stuff Together!");
	
	//Buttons
	private Button btnStart = new Button("Start Collecting!");
	private Button btnGoToCollection = new Button("View/Organize Collection!");
	private Button btnExit = new Button("Exit");	//Will change to red color later
	//private Button btnCreateNewItem = new Button("Create New Object!");		will be added after collection screen is created

	
	//Methods
	public HomeScreen() {
		addObjectsToContainers();
		setPadding();
		//activateButtons();
		exitAppListener();
		showApp();
	}

	private void addObjectsToContainers() {
		//Add everything to separate containers 
		titleHolder.getChildren().add(title);
		taglineHolder.getChildren().add(tagline);
		startButtonOrCreateNewItemObject.getChildren().add(btnStart);
		goToCollectionButtonObject.getChildren().add(btnGoToCollection);
		exitButtonObject.getChildren().add(btnExit);
		//Add everything but exit button to one container
		everythingButExit.getChildren().addAll(titleHolder,taglineHolder,startButtonOrCreateNewItemObject,goToCollectionButtonObject); //Will add createNewItemButtonItem
		
		//Add everything to mainContainer
		
		mainContainer.setCenter(everythingButExit);
		mainContainer.setTop(exitButtonObject);
	}
	
	private void setPadding() {
		exitButtonObject.setPadding(new Insets(0, 20, 50, 100));	//top,right,bottom,left
		titleHolder.setPadding(new Insets(0, 50, 10, 50));
		
	}
	
	/* private void activateButtons() {
		// Will use for buttons to go to other screens
		
	} */
	
	/*private void disableUnnecessaryButtons(){
		//Will use to disable Start button after first press -- Will change to createNewItemButtonItem
		
		startButtonOrCreateNewItemObject.getChildren().remove(btnStart);
		startButtonOrCreateNewItemObject.getChildren().add(btnCreateNewItem);
		} */
	
	private void exitAppListener() {
		btnExit.setOnAction(e -> {
			exitApp();
		});
	}
	
	private void exitApp() {
		Platform.exit();
	}

	private void showApp() {		
		Stage stage = new Stage();
		Scene scene = new Scene(mainContainer,1000,750);	//first #: length, second #: height
		stage.setTitle("GYST");
		stage.setScene(scene);
		stage.show();	
	}
}
