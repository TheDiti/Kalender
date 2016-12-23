package ch.csbe.kalender;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.fxml.FXML;
import javafx.print.PrinterJob;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
/**
 * 
 * @author Endrit
 * 
 * Dies ist die KalenderAusgabe Klasse. Hier wird der Kalender ausgegeben
 * inkl. Bilder.
 *
 */
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
	@FXML
	public Pane pane9;

	/*
	 * in kal() wir der monat und das jahr von der Kalenderklasse übernommen
	 * und hier ausgegeben. Ausserdem werden noch die gespeichertent Bilder
	 * hier ausgelesen und augegeben. Dann wird noch der Kalender ausgegeben.
	 */
	public void kal(String monat, String jahr) {
		this.monat.setText(monat);							//hier wird der Monat ausgegeben
		this.jahr.setText(jahr);							//hier wird das Jahr ausgegeben
		this.monat.setTextAlignment(TextAlignment.CENTER);

		//Hier wird kontrolliert ob man einen oder zwei Templates verwendet
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
		
		//Hier wird kontrolliert welchen Monat man auswählt
		 int mon = 0;
		 switch(monat){
		 	case"Januar": mon = 0; break;
		 	case"Februar": mon = 1; break;
		 	case"März": mon = 2; break;
		 	case"April": mon = 3; break;
			case"Mai": mon = 4; break;
			case"Juni": mon = 5; break;
			case"Juli": mon = 6; break;
			case"August": mon = 7; break;
			case"September": mon = 8; break;
			case"Oktober": mon = 9; break;
			case"November": mon = 10; break;
			case"Dezember": mon = 11; break;
			default : mon = 0;
		}
		 
		 //hier wird der Kalender erstellt und ausgegeben
		GregorianCalendar cal = new GregorianCalendar(Integer.parseInt(jahr),mon,1);
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		cal.set(Calendar.DAY_OF_MONTH, -(7-day));
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				Text t = new Text(getDate(cal));

				GridPane.setRowIndex(t, i);
				GridPane.setColumnIndex(t, j);
				gp.getChildren().addAll(t);
				cal.add(Calendar.DATE, 1);
			}
		}

	}
	
	//hier wird das datum ausgerechnet
	public String getDate(GregorianCalendar cal) {
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
		fmt.setCalendar(cal);
		return fmt.format(cal.getTime());
	}

	//weiter() wechselt zur Kalender Klasse
	@FXML
	protected void weiter() {
		Kalender k = new Kalender();
		new Navigator().navigate(k);
	}
	
	@FXML
	protected void exp(){
		System.out.println("Hallo");
		PrinterJob pj = PrinterJob.createPrinterJob();
		if(pj != null){
			System.out.println("Nei silvan passiert nid");
			pj.showPrintDialog(KalApp.primaryStage);
			//pj.printPage(pane9);
			//pj.endJob();
		}
	}

}
