package screentools;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Caption extends HBox {
	
	Text subtitle = new Text();
	
	public Caption(String caption) {
		this.getChildren().add(subtitle);
		this.subtitle.setText(caption);
	}

}
