public class Frog
{
  private final Point location;
  private final int tongueLength;

  public Point getLocation()
  {
    return location;
  }

  public int getTongueLength()
  {
    return tongueLength;
  }

  public Frog(Point location, int tongueLength)
  {
    this.location = location;
    this.tongueLength = tongueLength;
  }
}