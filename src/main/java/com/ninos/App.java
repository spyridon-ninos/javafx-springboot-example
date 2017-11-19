package com.ninos;

import com.ninos.ui.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App extends Application {

	private static String[] args;

	public static void main(String[] args) {
		App.args = args;
		launch(App.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, App.args);
		MainWindow mainWindow = context.getBean(MainWindow.class);
		mainWindow.start(primaryStage);
	}
}
