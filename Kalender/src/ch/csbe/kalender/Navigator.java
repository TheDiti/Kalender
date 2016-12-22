package ch.csbe.kalender;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Navigator {

	public void navigate(Controller c) {
		String next = c.getClass().getSimpleName().toLowerCase();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ch/csbe/fxml/" + next + ".fxml"));
		loader.setController(c);

		Parent par;
		try {
			par = loader.load();
			Scene scene = new Scene(par);
			KalApp.primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
