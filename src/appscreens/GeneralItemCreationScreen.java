package appscreens;

import java.util.Arrays;

import buttons.ExitButton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project_data.GystData;
import screentools.FormEntryArea;

public class GeneralItemCreationScreen {
	
	Stage stage = new Stage();
	
	//Containers
	BorderPane mainScreen = new BorderPane();		//Note to self: 3 columns and 3 rows will eventually be needed!
	
	HBox titleHolder = new HBox();
	HBox optionalCaptionHolder = new HBox();
	HBox saveBtnObject = new HBox();
	
	VBox formEntryAndText = new VBox();
	
	
	//Attributes
	
		//Title and Caption
	Text title = new Text("Please Fill Out Information Below");
	Text optionalCaption = new Text("Please Note: You May Leave Areas Marked as (OPTIONAL) Blank, if you prefer.");
	
		//Form Entry Area
	String[] labels = {"Item Name: ","Item Location: ","(OPTIONAL) Year Item Acquired: "};	//How to make so that year can only be a four digit number?
	FormEntryArea formEntrySpace = new FormEntryArea(labels);
	
		//Buttons
	ExitButton btnExit = new ExitButton(stage);
	private Button saveButton = new Button("Save");
	
		//

	
	
	//Constructor
	public GeneralItemCreationScreen() {
		placeObjectsInContainers();
		saveButtonListener();
		showApp();
	}



	private void placeObjectsInContainers() {
		
		saveBtnObject.getChildren().add(saveButton);
		
		titleHolder.getChildren().add(title);
		optionalCaptionHolder.getChildren().add(optionalCaption);
		
		formEntryAndText.getChildren().addAll(title,optionalCaption,formEntrySpace);
		
		//Put everything in mainContainer
				mainScreen.setCenter(formEntryAndText);
				mainScreen.setBottom(saveBtnObject);
				mainScreen.setRight(btnExit);
	}
	
	private void saveButtonListener() {
		saveButton.setOnAction(e -> {
			String[] savedData = formEntrySpace.getValues();
			
			GystData dbObj = new GystData();
			dbObj.insertIntoItems(savedData[0], savedData[1], Integer.parseInt(savedData[2]));
		});
		
	}
	
	/*private void getData() {
		
	} */
	
	private void showApp() {
		Scene scene = new Scene(mainScreen,950,750);	//first #: length, second #: height
		stage.setTitle("GYST");
		stage.setScene(scene);
		stage.show();		
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/* Other Old Code 2.0
	
		//Container for Labels TextFields (except for "General" Label)
	VBox allLabelsAndTextFields = new VBox();
	
		//Container for General Label
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	//Constructor
	public GeneralItemCreationScreen() {
		placeObjectsInContainers();
		showApp();
	}
	

	//Methods
	private void placeObjectsInContainers() {
		//Place FormFields into VBox()
		allLabelsAndTextFields.getChildren().addAll(itemIDNumber, itemName, itemLocation, itemYearAcquired);
		
		//Put everything in mainContainer
		mainScreen.add(allLabelsAndTextFields, 1, 2, 3, 5);
	}
	
	/////////////////////OLD CODE STARTS HERE/////////////////////////
	/* //Containers

	

	
		//Containers for Buttons
	HBox finishCreatingItemButtonObject = new HBox();
	HBox backButtonObject = new HBox();
	HBox exitButtonObject = new HBox();
	
		//Containers to hold multiple other containers
	VBox allLabelsExceptGeneralItemLabel = new VBox();
	VBox allTextFields = new VBox();
	HBox backAndCreateButtons = new HBox();
	VBox textAndGeneralItemLabel = new VBox();
	HBox labelsAndTextFields = new HBox();
	
	//Attributes
	
		//Text
	Text title = new Text("Please Fill Out Information Below");
	Text optionalCaption = new Text("Please Note: You May Leave Areas Marked as (OPTIONAL) Blank, if you prefer.");
	
		//Labels
	Label generalItem = new Label("General");
	
	Label itemIDNumber = new Label("Item ID Number: ");
	Label itemName = new Label("Item Name: ");
	Label itemLocation = new Label("Item Location: ");
	Label itemYearAcquired = new Label("(OPTIONAL) Year Item Acquired: ");
	
		//TextFields
	
	TextField settingItemIDNumber = new TextField("PLACEHOLDER--link to database for needed id # goes here");		//Will be incremented from pre-existing database info	
	TextField enterItemName = new TextField();
	TextField enterItemLocation = new TextField();
	TextField enterItemYearAcquired = new TextField();
	
	//Buttons
	private Button btnCreate = new Button("Complete Item Creation");
	private Button btnBack = new Button("Back");
	private Button btnExit = new Button("Exit");
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	//Methods
	private void placeObjectsInContainers() {
			
			//Put text into containers
		titleHolder.getChildren().add(title);
		optionalCaptionHolder.getChildren().add(optionalCaption);
		
			//Put labels into containers
		generalItemLabelHolder.getChildren().add(generalItem);
		
		itemIDNumberLabelHolder.getChildren().add(itemIDNumber);
		itemNameLabelHolder.getChildren().add(itemName);
		itemLocationLabelHolder.getChildren().add(itemLocation);
		itemYearAcquiredLabelHolder.getChildren().add(itemYearAcquired);
		
			//Put TextFields into containers
		alreadySetItemIDNumber.getChildren().add(settingItemIDNumber);
		enterItemNameTextFieldHolder.getChildren().add(enterItemName);
		enterItemLocationTextFieldHolder.getChildren().add(enterItemLocation);
		enterItemYearAcquiredTextFieldHolder.getChildren().add(enterItemYearAcquired);
		
			//Put Buttons into containers
		finishCreatingItemButtonObject.getChildren().add(btnCreate);
		backButtonObject.getChildren().add(btnBack);
		exitButtonObject.getChildren().add(btnExit);
		
			//Put (some) containers into other containers
				//Put all labels together except general item
		allLabelsExceptGeneralItemLabel.getChildren().addAll(itemIDNumberLabelHolder,itemNameLabelHolder,itemLocationLabelHolder,itemYearAcquiredLabelHolder);
		
				//All TextFields
		allTextFields.getChildren().addAll(alreadySetItemIDNumber,enterItemNameTextFieldHolder,enterItemLocationTextFieldHolder,enterItemYearAcquiredTextFieldHolder);
		
				//Labels and TextFields together
		labelsAndTextFields.getChildren().addAll(allLabelsExceptGeneralItemLabel,allTextFields);
		
				//Buttons (except for exit)
		backAndCreateButtons.getChildren().addAll(backButtonObject,finishCreatingItemButtonObject);
		
				//Everything else (except exit button)
		 textAndGeneralItemLabel.getChildren().addAll(titleHolder,generalItemLabelHolder,optionalCaption);
		
		placeContainersOnGridPane();
		
	}

	private void placeContainersOnGridPane() {
			//Place title, general item label, and caption in column: 1 (usually starts at 0) row: 1 (usually starts at 0) with a column width of 3 and row width of 1
		mainScreen.add(textAndGeneralItemLabel, 1, 1, 3, 1); //column, row, column span, row span
		
			//Place other labels and all textFields in column: 1 and row: 2 with a column width of 3 and row width of 5
		mainScreen.add(labelsAndTextFields, 1, 2, 3, 5);
		
			//Place exit button on screen in column---INCOMPLETE
		mainScreen.add(exitButtonObject, 0, 0);
	} */
}
