import java.util.ArrayList;

public class Grasshopper
{
  private ArrayList<Point> travelPlan;
  private int currentPointIndex;
  private Point currentLocation;

  public void setTravelPlan(ArrayList<Point> travelPlan)
  {
    this.travelPlan = travelPlan;
    currentPointIndex = 0;
  }

  public int getPointNumber()
  {
    return currentPointIndex + 1;
  }

  public void jump()
  {
    if (!atEnd())
    {
      currentLocation = travelPlan.get(currentPointIndex);
    }
  }

  public void notifyJumpSuccess()
  {
    currentPointIndex++;
  }

  public Point getLocation()
  {
    return currentLocation;
  }

  public boolean atEnd()
  {
    return currentPointIndex == travelPlan.size();
  }
}