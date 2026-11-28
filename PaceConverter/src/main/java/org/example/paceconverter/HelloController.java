package org.example.paceconverter;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController
{
  private final String SPEED_VALUE_REGEX = "\\d*([.,]\\d*)?";
  private final String MINUTES_VALUE_REGEX = "\\d*";
  private final String SECONDS_VALUE_REGEX = "([0-5]?\\d)?";
  private final String DOUBLE_FORMAT = "%.1f";

  @FXML
  private Button btnCalculate;

  @FXML
  private ToggleGroup grpPaceType;

  @FXML
  private RadioButton radPace;

  @FXML
  private RadioButton radSpeed;

  @FXML
  private RadioButton radSummerLap;

  @FXML
  private RadioButton radWinterLap;

  @FXML
  private TextField txtPaceMin;

  @FXML
  private TextField txtPaceSec;

  @FXML
  private TextField txtSpeed;

  @FXML
  private TextField txtSummerLapMin;

  @FXML
  private TextField txtSummerLapSec;

  @FXML
  private TextField txtWinterLapMin;

  @FXML
  private TextField txtWinterLapSec;

  @FXML
  public void initialize()
  {
    setupSpeedFilter(txtSpeed);

    setupMinutesFilter(txtPaceMin);
    setupSecondsFilter(txtPaceSec);

    setupMinutesFilter(txtSummerLapMin);
    setupSecondsFilter(txtSummerLapSec);

    setupMinutesFilter(txtWinterLapMin);
    setupSecondsFilter(txtWinterLapSec);
  }

  private void setupSpeedFilter(TextField field)
  {
    TextFormatter<String> formatter = new TextFormatter<>(change ->
    {
      String newText = change.getControlNewText();
      return newText.matches(SPEED_VALUE_REGEX) ? change : null;
    });

    field.setTextFormatter(formatter);
  }

  private void setupMinutesFilter(TextField field)
  {
    TextFormatter<String> formatter = new TextFormatter<>(change ->
    {
      String newText = change.getControlNewText();
      return newText.matches(MINUTES_VALUE_REGEX) ? change : null;
    });

    field.setTextFormatter(formatter);
  }

  private void setupSecondsFilter(TextField field)
  {
    TextFormatter<String> formatter = new TextFormatter<>(change ->
    {
      String newText = change.getControlNewText();
      return newText.matches(SECONDS_VALUE_REGEX) ? change : null;
    });

    field.setTextFormatter(formatter);
  }

  @FXML
  protected void onRadSpeedClick()
  {
    resetTextFields();
    txtSpeed.setDisable(false);
  }

  @FXML
  protected void onRadPaceClick()
  {
    resetTextFields();
    txtPaceMin.setDisable(false);
    txtPaceSec.setDisable(false);
  }

  @FXML
  protected void onRadSummerLapClick()
  {
    resetTextFields();
    txtSummerLapMin.setDisable(false);
    txtSummerLapSec.setDisable(false);
  }

  @FXML
  protected void onRadWinterLapClick()
  {
    resetTextFields();
    txtWinterLapMin.setDisable(false);
    txtWinterLapSec.setDisable(false);
  }

  @FXML
  protected void onBtnCalculateClick()
  {
    switch (grpPaceType.getSelectedToggle())
    {
      case RadioButton rad when rad == radSpeed:
      {
        convertSpeed();
        return;
      }

      case RadioButton rad when rad == radPace:
      {
        convertPace();
        return;
      }

      case RadioButton rad when rad == radSummerLap:
      {
        convertSummerLapPace();
        return;
      }

      case RadioButton rad when rad == radWinterLap:
      {
        convertWinterLapPace();
        return;
      }

      case null:
      default:
      {
      }
    }
  }

  private void resetTextFields()
  {
    txtSpeed.setDisable(true);
    txtPaceMin.setDisable(true);
    txtPaceSec.setDisable(true);
    txtSummerLapMin.setDisable(true);
    txtSummerLapSec.setDisable(true);
    txtWinterLapMin.setDisable(true);
    txtWinterLapSec.setDisable(true);
  }

  private void convertSpeed()
  {
    double speed = readDoubleValue(txtSpeed);

    setPace(PaceSpeedConverter.speedToPace(speed));
    setSummerLapPace(PaceSpeedConverter.speedToSummerLap(speed));
    setWinterLapPace(PaceSpeedConverter.speedToWinterLap(speed));
  }

  private void convertPace()
  {
    int minutes = readIntegerValue(txtPaceMin);
    int seconds = readIntegerValue(txtPaceSec);
    MinutesAndSeconds minutesAndSeconds = new MinutesAndSeconds(minutes, seconds);

    setSpeed(PaceSpeedConverter.paceToSpeed(minutesAndSeconds));
    setSummerLapPace(PaceSpeedConverter.paceToSummerLap(minutesAndSeconds));
    setWinterLapPace(PaceSpeedConverter.paceToWinterLap(minutesAndSeconds));
  }

  private void convertSummerLapPace()
  {
    int minutes = readIntegerValue(txtSummerLapMin);
    int seconds = readIntegerValue(txtSummerLapSec);
    MinutesAndSeconds minutesAndSeconds = new MinutesAndSeconds(minutes, seconds);

    setSpeed(PaceSpeedConverter.summerLapToSpeed(minutesAndSeconds));
    setPace(PaceSpeedConverter.summerLapToPace(minutesAndSeconds));
    setWinterLapPace(PaceSpeedConverter.summerLapToWinterLap(minutesAndSeconds));
  }

  private void convertWinterLapPace()
  {
    int minutes = readIntegerValue(txtWinterLapMin);
    int seconds = readIntegerValue(txtWinterLapSec);
    MinutesAndSeconds minutesAndSeconds = new MinutesAndSeconds(minutes, seconds);

    setSpeed(PaceSpeedConverter.winterLapToSpeed(minutesAndSeconds));
    setPace(PaceSpeedConverter.winterLapToPace(minutesAndSeconds));
    setSummerLapPace(PaceSpeedConverter.winterLapToSummerLap(minutesAndSeconds));
  }

  private double readDoubleValue(TextField field)
  {
    String text = field.getText().trim().replace(',', '.');
    return Double.parseDouble(text);
  }

  private int readIntegerValue(TextField field)
  {
    String text = field.getText().trim();
    return Integer.parseInt(text);
  }

  private void setSpeed(double speed)
  {
    txtSpeed.setText(String.format(DOUBLE_FORMAT, speed));
  }

  private void setPace(MinutesAndSeconds minutesAndSeconds)
  {
    txtPaceMin.setText(String.valueOf(minutesAndSeconds.getMinutes()));
    txtPaceSec.setText(String.valueOf(minutesAndSeconds.getSeconds()));
  }

  private void setSummerLapPace(MinutesAndSeconds minutesAndSeconds)
  {
    txtSummerLapMin.setText(String.valueOf(minutesAndSeconds.getMinutes()));
    txtSummerLapSec.setText(String.valueOf(minutesAndSeconds.getSeconds()));
  }

  private void setWinterLapPace(MinutesAndSeconds minutesAndSeconds)
  {
    txtWinterLapMin.setText(String.valueOf(minutesAndSeconds.getMinutes()));
    txtWinterLapSec.setText(String.valueOf(minutesAndSeconds.getSeconds()));
  }
}