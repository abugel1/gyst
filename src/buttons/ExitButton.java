package buttons;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ExitButton extends HBox {
	
	private Button exitButton = new Button("Exit");
	
	//Constructor
	public ExitButton(Stage stage) {
		this.getChildren().add(exitButton);
		exitAppListener(stage);
		makeButtonPretty();
	}

	private void exitAppListener(Stage stage) {
		exitButton.setOnAction(e -> {
			stage.close();
		});
	}
	
	private void makeButtonPretty() {
		// TODO Auto-generated method stub
		
	}
}
