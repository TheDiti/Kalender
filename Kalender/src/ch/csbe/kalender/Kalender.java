package ch.csbe.kalender;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Kalender {

	@FXML protected Button weiter;
	
	@FXML
	public void weiter(ActionEvent event){
		System.out.println("Hallo");
	}
}
