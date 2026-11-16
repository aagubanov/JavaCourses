public class Grasshopper
{
  private Point location;

  public Point getLocation()
  {
    return location;
  }

  public void jumpsTo(Point newLocation)
  {
    location = newLocation;
  }
}