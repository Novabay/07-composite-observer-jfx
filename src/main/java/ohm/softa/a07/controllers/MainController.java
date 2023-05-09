package ohm.softa.a07.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import ohm.softa.a07.api.OpenMensaAPI;
import ohm.softa.a07.model.Meal;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MainController implements Initializable {
	private static final Logger logger = LogManager.getLogger(MainController.class);
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
	private final OpenMensaAPI openMensaAPI;
	// use annotation to tie to component in XML
	@FXML
	private Button btnRefresh;

	@FXML
	public Button btnClose;
	@FXML
	public CheckBox chkVegetarian;

	@FXML
	private ListView<String> mealsList;

	private ObservableList<Meal> meals;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// set the event handler (callback)
		btnRefresh.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// create a new (observable) list and tie it to the view
				ObservableList<String> list = FXCollections.observableArrayList("Hans", "Dampf");
				mealsList.setItems(list);
			}
		});

		btnClose.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				// get a handle to the stage
				Stage stage = (Stage) btnClose.getScene().getWindow();
				// do what you have to do
				stage.close();
			}
		});

		chkVegetarian.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){

			}
		});
	}
}
