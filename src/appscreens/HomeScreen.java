package appscreens;
import buttons.ExitButton;
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
import screentools.MainTitle;

public class HomeScreen extends Application{

	Stage homeScreenStage = new Stage();
	
	//Containers
	BorderPane mainContainer = new BorderPane();
	
	HBox taglineHolder = new HBox();
	HBox startButtonOrCreateNewItemObject = new HBox();
	HBox goToCollectionButtonObject = new HBox();
	
	VBox everythingButExit = new VBox();
	
	
	//Text
	MainTitle title = new MainTitle("G.Y.S.T");
	Text tagline = new Text("Get Your Stuff Together!");
	
	//Buttons
	private Button btnStart = new Button("Create New Item!");		//Originally stated "Start collecting!" and was supposed to switch to create new item after first button press. Cut due to time constraint and buttons correlated into one "Create New Item!" Button
	private Button btnGoToCollection = new Button("View/Organize Collection!");
	private ExitButton btnExit = new ExitButton(homeScreenStage);
	//private Button btnCreateNewItem = new Button("Create New Item!");		will be added after collection screen is created

	
	//Constructor
	public HomeScreen() {
		addObjectsToContainers();
		setPadding();
		makeButtonsPretty();
		activateButtons();
		showApp();
	}
	
	//Methods
	private void addObjectsToContainers() {
		//Add everything to separate containers 
		taglineHolder.getChildren().add(tagline);
		startButtonOrCreateNewItemObject.getChildren().add(btnStart);
		goToCollectionButtonObject.getChildren().add(btnGoToCollection);
		
		//Add everything but exit button to one container
		everythingButExit.getChildren().addAll(title,taglineHolder,startButtonOrCreateNewItemObject,goToCollectionButtonObject); //Will add createNewItemButtonItem
		
		//Add everything to mainContainer
		mainContainer.setCenter(everythingButExit);
		mainContainer.setTop(btnExit);
	}
	
	private void setPadding() {
		btnExit.setPadding(new Insets(20, -50, 0, 850));	//top,right,bottom,left
		title.setPadding(new Insets(0, 50, 10, 50));
		
	}
	
	private void makeButtonsPretty() {
		//Make Start button and Create Item Buttons Pretty
			//btnStart.setStyle(null);
		
		/* Will be styled in ExitButton
		 * //Make Exit Button Pretty
		btnExit.setStyle("-fx-background-color: #FF0000;-fx-text-fill: #000000;-fx-font-size: 25;");
			// -fx-border-color: #000000; -fx-border-width: 2px; */
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
		start(homeScreenStage);
		homeScreenStage.close();
	}

	@Override
	public void start(Stage stage) {
		new SelectItemType();
	}

	//Will cut out for time saving
		/*private void disableUnnecessaryButtons(){
			//Will use to disable Start button after first press -- Will change to createNewItemButtonItem
		
			startButtonOrCreateNewItemObject.getChildren().remove(btnStart);
			startButtonOrCreateNewItemObject.getChildren().add(btnCreateNewItem);
			} */

	protected void showApp() {		
		Scene homeScreenScene = new Scene(mainContainer,950,750);	//first #: length, second #: height
		homeScreenStage.setTitle("GYST");
		homeScreenStage.setScene(homeScreenScene);
		homeScreenStage.show();	
	}
}
