
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.event.EventTarget;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button bt1, bt2, bt3, bt4, bt5, bt6;
	Label mainLabel;
	TextField textField;
	//  declare two HBoxes
	HBox firstBox;
	HBox secondBox;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		bt1 = new Button("Hello");
		bt2 = new Button("Howdy");
		bt3 = new Button("Chinese");
		bt4 = new Button("Clear");
		bt5 = new Button("Exit");
		bt6 = new Button("Espanol");
		mainLabel = new Label("Feedback");
		textField = new TextField();
		//  instantiate the HBoxes
	    firstBox = new HBox();
	    secondBox = new HBox();
		//student Task #4:
		//  instantiate the DataManager instance
	     dataManager = new DataManager();
		//  set margins and set alignment of the components
	     HBox.setMargin(bt1, new Insets(10,30,30,0));
	     HBox.setMargin(bt2, new Insets(10,30,30,0));
	     HBox.setMargin(bt3, new Insets(10,30,30,0));
	     HBox.setMargin(bt4, new Insets(10,30,30,0));
	     HBox.setMargin(bt5, new Insets(10,0,30,0));
	     HBox.setMargin(bt6, new Insets(10,0,30,30));
	     HBox.setMargin(mainLabel, new Insets(0,20,0,0));
	     firstBox.setAlignment(Pos.CENTER);
	     secondBox.setAlignment(Pos.CENTER);
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
	    firstBox.getChildren().addAll(mainLabel, textField);
		//  add the buttons to the other HBox
	    secondBox.getChildren().addAll(bt1, bt2, bt3, bt4, bt5, bt6);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(firstBox, secondBox);
		
		bt1.setOnAction(new ButtonHandler());
		bt2.setOnAction(new ButtonHandler());
		bt3.setOnAction(new ButtonHandler());
		bt4.setOnAction(new ButtonHandler());
		bt5.setOnAction(new ButtonHandler());
		bt6.setOnAction(new ButtonHandler());

	}
		
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
		EventTarget e = event.getTarget();
		
		if (e == bt1) {
			textField.setText(dataManager.getHello());
		}
		if (e == bt2) {
			textField.setText(dataManager.getHowdy());
		}
		if (e == bt3) {
			textField.setText(dataManager.getChinese());
		}
		 if (e == bt4) {
			textField.setText("");
		}
		 if (e == bt6) {
			 textField.setText(dataManager.getEspanol());
		 }
		 else if (e == bt5 ) {
			 Platform.exit();
			 System.exit(0);
		 }
	}
	}
}
	
