package appscreens;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class GeneralItemCreationScreen {
	
	GridPane mainScreen = new GridPane();		//Note to self: 3 columns and 8 rows will eventually be needed!
	
	HBox titleHolder = new HBox();
	HBox optionalCaptionHolder = new HBox();
	
	//Text
	Text title = new Text("Please Fill Out Information Below");
	Text optionalCaption = new Text("Please Note: You May Leave Areas Marked as (OPTIONAL) Blank, if you prefer.");
	
	//Labels
	Label generalItem = new Label("General");
	Label itemIDNumber = new Label("Item ID Number: ");
	Label itemName = new Label("Item Name: ");
	Label itemLocation = new Label("Item Location: ");
	Label itemYearAcquired = new Label("Year Item Acquired (OPTIONAL): ");
	
	//Constructor
	public GeneralItemCreationScreen() {
		placeObjectsInContainers();
	}

	private void placeObjectsInContainers() {
		placeContainersOnGridPane();
		
	}

	private void placeContainersOnGridPane() {
		// TODO Auto-generated method stub
		
	}
}
