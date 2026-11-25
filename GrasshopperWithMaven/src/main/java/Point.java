public class Point
{
  private final int x;
  private final int y;

  public Point(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public double distanceTo(Point other)
  {
    int deltaX = x - other.x;
    int deltaY = y - other.y;

    // Euclid distance
    return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
  }
}