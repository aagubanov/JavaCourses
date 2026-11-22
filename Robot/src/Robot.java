import java.util.HashSet;

public class Robot
{
  private Direction direction;

  private  record Location(int x, int y)
  {
  };

  private Location location;
  private final HashSet<Location> locations;

  private boolean hasRepeatedLocation;
  private int stepsUpToRepeat;

  public Robot()
  {
    direction = Direction.FORWARD;
    location = new Location(0, 0);

    locations  = new HashSet<Location>();
    locations.add(this.location);

    hasRepeatedLocation = false;
    stepsUpToRepeat = -1;
  }

  public void execute(char command)
  {
    char ch = Character.toUpperCase(command);

    switch (ch)
    {
      case 'L' -> turnLeft();
      case 'R' -> turnRight();
      case 'S' -> step();
    };
  }

  private void turnLeft()
  {
    direction = direction.previous();
  }

  private void turnRight()
  {
    direction = direction.next();
  }

  private void step()
  {
    switch (direction)
    {
      case Direction.FORWARD -> location = new Location(location.x(), location.y() + 1);
      case Direction.RIGHT -> location = new Location(location.x() + 1, location.y());
      case Direction.BACKWARD -> location = new Location(location.x(), location.y() - 1);
      case Direction.LEFT -> location = new Location(location.x() - 1, location.y());
    }

    if (hasRepeatedLocation)
    {
      // Further processing is no longer required
      return;
    }

    hasRepeatedLocation = !locations.add(location);
    if (hasRepeatedLocation)
    {
      stepsUpToRepeat = locations.size();
    }
  }

  public int getStepsUpToRepeat()
  {
    return stepsUpToRepeat;
  }
}