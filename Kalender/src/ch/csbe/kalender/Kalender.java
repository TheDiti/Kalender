package ch.csbe.kalender;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

public class Kalender extends Controller {

	public static boolean template = true;

	@FXML
	public ComboBox<String> cb1;
	@FXML
	public ComboBox<String> cb3;
	@FXML
	public Button tm1;
	@FXML
	public Button tm2;
	@FXML
	public ImageView img;
	@FXML
	public ImageView img1;
	@FXML
	public ImageView img2;
	@FXML
	public Pane pn1;
	@FXML
	public Pane pn11;
	@FXML
	public Pane pn2;
	@FXML
	public Pane pn22;
	@FXML
	public Pane pane3;
	@FXML
	public Pane pane4;
	@FXML
	public Pane pane5;

	final FileChooser fileChooser = new FileChooser();

	@FXML
	protected void cb1() {
		cb1.setItems(FXCollections.observableArrayList("Januar", "Februar", "März", "April", "Mai", "Juni", "Juli",
				"August", "September", "Oktober", "November", "Dezember"));
	}

	@FXML
	protected void tm1() {
		template = true;
		pn1.setVisible(true);
		pn11.setVisible(true);
		if (pn2.isVisible() == true) {
			pn2.setVisible(false);
			pn22.setVisible(false);
		}
	}

	@FXML
	protected void tm2() {
		template = false;
		pn11.setVisible(true);
		pn2.setVisible(true);
		pn22.setVisible(true);
		if (pn1.isVisible() == true) {
			pn1.setVisible(false);
		}
	}

	@FXML
	protected void cb3() {
		cb3.setItems(FXCollections.observableArrayList("2017", "2018", "2019", "2020"));
	}

	@FXML
	protected void browse() {

		if (pn1.isVisible() == true) {
			FileChooser fileChooser = new FileChooser();

			FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
			FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
			fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

			File file = fileChooser.showOpenDialog(null);

			try {
				BufferedImage bufferedImage = ImageIO.read(file);
				Image image = SwingFXUtils.toFXImage(bufferedImage, null);
				img.setImage(image);
				img.setFitWidth(200);
				img.setFitHeight(200);

				File f = new File("src/ch/csbe/bilder/bilder.png");
				if (!f.exists()) {
					f.mkdir();
				}
				if (f != null) {
					try {
						ImageIO.write(bufferedImage, "png", f);
					} catch (IOException ex) {

					}
				}

			} catch (IOException ex) {
				Logger.getLogger(Kalender.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else if (pn2.isVisible() == true) {
			FileChooser fileChooser = new FileChooser();

			FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
			FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
			fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

			File file = fileChooser.showOpenDialog(null);

			try {
				BufferedImage bufferedImage = ImageIO.read(file);
				Image image = SwingFXUtils.toFXImage(bufferedImage, null);
				img1.setImage(image);
				img1.setFitWidth(200);
				img1.setFitHeight(200);

				File f = new File("src/ch/csbe/bilder/bild1.png");
				if (!f.exists()) {
					f.mkdir();
				}
				if (f != null) {
					try {
						ImageIO.write(bufferedImage, "png", f);
					} catch (IOException ex) {

					}
				}

			} catch (IOException ex) {
				Logger.getLogger(Kalender.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}

	@FXML
	protected void browse2() {
		FileChooser fileChooser = new FileChooser();

		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

		File file = fileChooser.showOpenDialog(null);

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			img2.setImage(image);
			img2.setFitWidth(200);
			img2.setFitHeight(200);

			File f = new File("src/ch/csbe/bilder/bild2.png");
			if (!f.exists()) {
				f.mkdir();
			}
			if (f != null) {
				try {
					ImageIO.write(bufferedImage, "png", f);
				} catch (IOException ex) {

				}
			}

		} catch (IOException ex) {
			Logger.getLogger(Kalender.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	protected void weiter() {

		KalenderAusgabe ka = new KalenderAusgabe();
		new Navigator().navigate(ka);

		String monat = cb1.getSelectionModel().getSelectedItem().toString();
		String jahr = cb3.getSelectionModel().getSelectedItem().toString();
		ka.kal(monat, jahr);

	}

}
