package org.example.paceconverter;

public class MinutesAndSeconds
{
  private static final int SECONDS_PER_MINUTE = 60;

  private final int minutes;
  private final int seconds;
  private final int totalSeconds;

  public MinutesAndSeconds(int totalSeconds)
  {
    this.totalSeconds = totalSeconds;
    minutes = (int)(totalSeconds / SECONDS_PER_MINUTE);
    seconds = (int) (totalSeconds - SECONDS_PER_MINUTE * minutes);
  }

  public MinutesAndSeconds(int minutes, int seconds)
  {
    this.minutes = minutes;
    this.seconds = seconds;
    totalSeconds = minutes * SECONDS_PER_MINUTE + seconds;
  }

  public int getMinutes()
  {
    return minutes;
  }

  public int getSeconds()
  {
    return seconds;
  }

  public int getTotalSeconds()
  {
    return totalSeconds;
  }
}