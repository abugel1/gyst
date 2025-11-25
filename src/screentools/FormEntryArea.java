package screentools;

import java.util.ArrayList;

import javafx.scene.layout.VBox;

public class FormEntryArea extends VBox {
	
	private ArrayList<FormField> formFields = new ArrayList<>();
	
	public FormEntryArea(String[] labels) {
		for(int i=0; i<labels.length;i++) {
			formFields.add(new FormField(labels[i]));
		}
		
		this.getChildren().addAll(formFields);
	}
	
	public FormEntryArea(String[] labels, String[] values) {
		for(int i=0; i<labels.length;i++) {
			formFields.add(new FormField(labels[i]));
		}
		
		this.getChildren().addAll(formFields);
	}
	
	public String[] getValues() {
		String[] values = new String[formFields.size()];
		
		for(int i=0;i<formFields.size();i++) {
			FormField temp = formFields.get(i);
			values[i] = temp.getValue();
		}
		return values;
	}
}
