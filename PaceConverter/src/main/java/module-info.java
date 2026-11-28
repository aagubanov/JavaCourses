module org.example.paceconverter {
  requires javafx.controls;
  requires javafx.fxml;


  opens org.example.paceconverter to javafx.fxml;
  exports org.example.paceconverter;
}