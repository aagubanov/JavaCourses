package org.example.paceconverter;

public class PaceSpeedConverter
{
  private static final int SECONDS_PER_HOUR = 3600;
  private static final double SUMMER_LAP_TO_KM = 0.4;
  private static final double WINTER_LAP_TO_KM = 0.2;

  public static MinutesAndSeconds speedToPace(double speed)
  {
    int totalSeconds = (int)(SECONDS_PER_HOUR / speed);
    return new MinutesAndSeconds(totalSeconds);
  }

  public static MinutesAndSeconds speedToSummerLap(double speed)
  {
    int secondsPerLap = (int)(SECONDS_PER_HOUR * SUMMER_LAP_TO_KM / speed);
    return new MinutesAndSeconds(secondsPerLap);
  }

  public static MinutesAndSeconds speedToWinterLap(double speed)
  {
    int secondsPerLap = (int)(SECONDS_PER_HOUR * WINTER_LAP_TO_KM / speed);
    return new MinutesAndSeconds(secondsPerLap);
  }

  public static double paceToSpeed(MinutesAndSeconds minutesAndSeconds)
  {
    int secondsPerKm = minutesAndSeconds.getTotalSeconds();
    return SECONDS_PER_HOUR / (double)secondsPerKm;
  }

  public static MinutesAndSeconds paceToSummerLap(MinutesAndSeconds minutesAndSeconds)
  {
    int totalSeconds = minutesAndSeconds.getTotalSeconds();
    int secondsPerLap = (int)(totalSeconds * SUMMER_LAP_TO_KM);

    return new MinutesAndSeconds(secondsPerLap);
  }

  public static MinutesAndSeconds paceToWinterLap(MinutesAndSeconds minutesAndSeconds)
  {
    int totalSeconds = minutesAndSeconds.getTotalSeconds();
    int secondsPerLap = (int)(totalSeconds * WINTER_LAP_TO_KM);

    return new MinutesAndSeconds(secondsPerLap);
  }

  public static double summerLapToSpeed(MinutesAndSeconds minutesAndSeconds)
  {
    int secondsPerKm = (int)(minutesAndSeconds.getTotalSeconds() / SUMMER_LAP_TO_KM);
    return SECONDS_PER_HOUR / (double)secondsPerKm;
  }

  public static MinutesAndSeconds summerLapToPace(MinutesAndSeconds minutesAndSeconds)
  {
    int secondsPerKm = (int)(minutesAndSeconds.getTotalSeconds() / SUMMER_LAP_TO_KM);
    return new MinutesAndSeconds(secondsPerKm);
  }

  public static MinutesAndSeconds summerLapToWinterLap(MinutesAndSeconds minutesAndSeconds)
  {
    int secondsPerLap = (int)(minutesAndSeconds.getTotalSeconds() * WINTER_LAP_TO_KM / SUMMER_LAP_TO_KM);
    return new MinutesAndSeconds(secondsPerLap);
  }

  public static double winterLapToSpeed(MinutesAndSeconds minutesAndSeconds)
  {
    int secondsPerKm = (int)(minutesAndSeconds.getTotalSeconds() / WINTER_LAP_TO_KM);
    return SECONDS_PER_HOUR / (double)secondsPerKm;
  }

  public static MinutesAndSeconds winterLapToPace(MinutesAndSeconds minutesAndSeconds)
  {
    int secondsPerKm = (int)(minutesAndSeconds.getTotalSeconds() / WINTER_LAP_TO_KM);
    return new MinutesAndSeconds(secondsPerKm);
  }

  public static MinutesAndSeconds winterLapToSummerLap(MinutesAndSeconds minutesAndSeconds)
  {
    int secondsPerLap = (int)(minutesAndSeconds.getTotalSeconds() * SUMMER_LAP_TO_KM / WINTER_LAP_TO_KM);
    return new MinutesAndSeconds(secondsPerLap);
  }
}