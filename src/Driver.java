import appscreens.HomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Driver extends Application {

	@Override
	public void start(Stage stage) {
		new HomeScreen();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
