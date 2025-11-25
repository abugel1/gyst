package screentools;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FormField extends HBox {

	TextField tFObj = new TextField();
	Label formLabel = new Label();
	
	public FormField(String labelText) {
		this.formLabel.setText(labelText);
		this.getChildren().addAll(formLabel, tFObj);
	}

	public TextField gettFObj() {
		return tFObj;
	}

	public void settFObj(String tFValue) {
		this.tFObj.setText(tFValue);
	}

	public Label getFormLabel() {
		return formLabel;
	}
	
	public String getValue() {
		return tFObj.getText();
	}

}
