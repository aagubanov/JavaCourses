import java.util.HashSet;

public class Robot
{
  private Direction direction;
  private Location location;
  private final HashSet<Location> locations;
  private boolean deja;

  public Robot(Direction direction, Location location)
  {
    this.direction = direction;
    this.location = location;

    locations  = new HashSet<Location>();
    locations.add(this.location);
    deja = false;
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

    if (!locations.add(location))
    {
      deja = true;
    }
  }

  public boolean getDeja()
  {
    return deja;
  }

  public int getSteps()
  {
    int locationCount = locations.size();
    return deja ? locationCount : -1;
  }
}