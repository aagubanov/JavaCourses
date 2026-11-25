public class Frog
{
  private final Point location;
  private final int tongueLength;

  public Frog(Point location, int tongueLength)
  {
    this.location = location;
    this.tongueLength = tongueLength;
  }

  public boolean canFeed(Point victimLocation)
  {
    return Point.distance(location, victimLocation) <= tongueLength;
  }
}