package ch.csbe.kalender;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class KalenderAusgabe extends Controller {

	@FXML
	public Text monat;
	@FXML
	public Text jahr;
	@FXML
	public Text jahr1;
	@FXML
	public Pane pane1;
	@FXML
	public Pane pane2;
	@FXML
	public Pane pn3;
	@FXML
	public Pane pn4;
	@FXML
	public ImageView iv1;
	@FXML
	public ImageView iv2;
	@FXML
	public ImageView iv3;
	@FXML
	public Pane kalender;
	@FXML
	public GridPane gp;

	public void kal(String monat, String jahr) {
		this.monat.setText(monat);
		this.jahr.setText(jahr);
		this.monat.setTextAlignment(TextAlignment.CENTER);

		if (Kalender.template == true) {
			pn3.setVisible(true);
			Image i = new Image("/ch/csbe/bilder/bilder.png");
			iv1.setImage(i);
		} else if (Kalender.template == false) {
			pn4.setVisible(true);
			Image i = new Image("/ch/csbe/bilder/bild1.png");
			Image im = new Image("/ch/csbe/bilder/bild2.png");
			iv2.setImage(i);
			iv3.setImage(im);
		}
		
		if(monat == "Januar"){
			
		}

//		for (int i = 0; i < 7; i++) {
//			for (int j = 0; j < 6; j++) {
//				Text t = new Text("Hello");
//
//				GridPane.setRowIndex(t, j);
//				GridPane.setColumnIndex(t, i);
//
//				gp.getChildren().addAll(t);
//			}
//		}

	}

	@FXML
	protected void weiter() {
		Kalender k = new Kalender();
		new Navigator().navigate(k);
	}

}
