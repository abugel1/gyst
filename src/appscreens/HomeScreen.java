package appscreens;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeScreen extends Application{

	Stage homeScreenStage = new Stage();
	
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
	private Button btnExit = new Button("Exit");
	//private Button btnCreateNewItem = new Button("Create New Item!");		will be added after collection screen is created

	
	//Constructor
	public HomeScreen() {
		addObjectsToContainers();
		setPadding();
		makeButtonsPretty();
		makeTextPretty();
		activateButtons();
		exitAppListener();
		showApp();
	}
	
	//Methods
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
		exitButtonObject.setPadding(new Insets(20, -50, 0, 850));	//top,right,bottom,left
		titleHolder.setPadding(new Insets(0, 50, 10, 50));
		
	}
	
	private void makeButtonsPretty() {
		//Make Start button and Create Item Buttons Pretty
			//btnStart.setStyle(null);
		
		//Make Exit Button Pretty
		btnExit.setStyle("-fx-background-color: #FF0000;-fx-text-fill: #000000;-fx-font-size: 25;");
			// -fx-border-color: #000000; -fx-border-width: 2px;
	}

	private void makeTextPretty() {
		title.setFont(Font.font("noto sans",FontWeight.BOLD,FontPosture.REGULAR,50));
		
	}
	
	private void activateButtons() {
		// For buttons to go to other screens
			startCollectingButtonListener();
			//goToCollectionButtonListener();
	}
	
	private void startCollectingButtonListener() {
		btnStart.setOnAction(e -> {
			goToSelectItemTypeScreen();
		});
		
	}

	private void goToSelectItemTypeScreen() {
		start(null);
		homeScreenStage.close();
	}

	@Override
	public void start(Stage stage) {
		new SelectItemType();
	}

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

	protected void showApp() {		
		Scene homeScreenScene = new Scene(mainContainer,950,750);	//first #: length, second #: height
		homeScreenStage.setTitle("GYST");
		homeScreenStage.setScene(homeScreenScene);
		homeScreenStage.show();	
	}
}
