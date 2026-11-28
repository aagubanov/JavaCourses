package org.example.paceconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application
{
  @Override
  public void start(Stage stage) throws IOException
  {
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Pace Converter");
    stage.setScene(scene);
    stage.show();

    stage.setMinWidth(stage.getWidth());
    stage.setMinHeight(stage.getHeight());
  }
}