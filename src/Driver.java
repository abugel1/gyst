//import appscreens.HomeScreen;
import appscreens.GeneralItemCreationScreen;
import appscreens.HomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;
//import project_data.GystData;

public class Driver extends Application {

	@Override
	public void start(Stage stage) {
		//new HomeScreen();
		//new GystData();
		new GeneralItemCreationScreen();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
