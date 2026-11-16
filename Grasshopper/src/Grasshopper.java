public class Grasshopper
{
  private Point location;

  public Grasshopper(Point location)
  {
    this.location = location;
  }

  public void jumpTo(Point newLocation)
  {
    location = newLocation;
  }

  public boolean isFed(Point dangerLocation, int dangerRadius)
  {
    return Point.distance(location, dangerLocation) <= dangerRadius;
  }
}