package screentools;

import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainTitle extends HBox {
	
	Text title = new Text();
	
	public MainTitle(String mainTitle) {
		this.getChildren().add(title);
		this.title.setText(mainTitle);
		makePretty();
	}

	private void makePretty() {
		title.setFont(Font.font("noto sans",FontWeight.BOLD,FontPosture.REGULAR,50));
	}
}
