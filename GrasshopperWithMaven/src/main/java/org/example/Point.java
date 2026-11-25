package org.example;

public class Point
{
  private final int x;
  private final int y;

  public Point(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point first, Point second)
  {
    int deltaX = first.x - second.x;
    int deltaY = first.y - second.y;

    // Euclid distance
    return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
  }

  public double distanceTo(Point other)
  {
    int deltaX = x - other.x;
    int deltaY = y - other.y;

    // Euclid distance
    return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
  }
}