import java.util.ArrayList;

public class InputData
{
  private int numberOfGrasshopperJumps;
  private Point frogLocation;
  private int frogTongueLength;
  private final ArrayList<Point> grasshopperLocations = new ArrayList<Point>();

  public int getNumberOfGrasshopperJumps()
  {
    return numberOfGrasshopperJumps;
  }

  public void setNumberOfGrasshopperJumps(int numberOfGrasshopperJumps)
  {
    this.numberOfGrasshopperJumps = numberOfGrasshopperJumps;
  }

  public Point getFrogLocation()
  {
    return frogLocation;
  }

  public void setFrogLocation(Point frogLocation)
  {
    this.frogLocation = frogLocation;
  }

  public int getFrogTongueLength()
  {
    return frogTongueLength;
  }

  public void setFrogTongueLength(int frogTongueLength)
  {
    this.frogTongueLength = frogTongueLength;
  }

  public void addGrasshopperLocation(Point location)
  {
    grasshopperLocations.add(location);
  }

  public Point getGrasshopperLocation(int index)
  {
    return grasshopperLocations.get(index);
  }
}