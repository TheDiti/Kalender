package ch.csbe.kalender;

import javafx.application.Application;
import javafx.stage.Stage;

public class KalApp extends Application {
	
	public static Stage primaryStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		KalApp.primaryStage = primaryStage;
		new Navigator().navigate(new Kalender());
		
		primaryStage.setTitle("Kalender");
		primaryStage.show();

	}

}
