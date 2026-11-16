public class Grasshopper
{
  private Point location;

  public Grasshopper()
  {
  }

  public void jumpsTo(Point newLocation)
  {
    location = newLocation;
  }

  public boolean isFed(Point dangerLocation, int dangerRadius)
  {
    return Point.distance(location, dangerLocation) <= dangerRadius;
  }
}