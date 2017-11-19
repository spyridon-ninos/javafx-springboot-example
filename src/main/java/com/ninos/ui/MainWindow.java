package com.ninos.ui;

import com.ninos.business.EventsRepository;
import com.ninos.business.model.Event;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.ListBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import static javafx.geometry.Pos.CENTER;

@Component
public class MainWindow {

	private static Logger logger = LoggerFactory.getLogger(MainWindow.class);
	private EventsRepository eventsRepository;

	@Inject
	public void setEventsRepository(EventsRepository eventsRepository) {
		this.eventsRepository = eventsRepository;
	}

	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button();
		btn.setText("Fetch Events");

		TableView<Event> eventTableView = new TableView<>();

		TableColumn firstCol = new TableColumn<>("Id");
		firstCol.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn secondCol = new TableColumn("Home");
		secondCol.setCellValueFactory(new PropertyValueFactory<>("home"));

		TableColumn thirdCol = new TableColumn("Away");
		thirdCol.setCellValueFactory(new PropertyValueFactory<>("away"));

		btn.setOnAction(e -> {
			List<Event> list = eventsRepository.getAllEvents();
			ObservableList<Event> observableList = FXCollections.observableList(list);
			eventTableView.setItems(observableList);
			eventTableView.getColumns().setAll(firstCol, secondCol, thirdCol);
		});


		VBox root = new VBox(10, btn, eventTableView);
		root.setAlignment(CENTER);

		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Hello JavaFX 8 World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
