import java.util.ArrayList;

public class InputData
{
  private int numberOfGrasshopperJumps;
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

  public ArrayList<Point> getGrasshopperLocations()
  {
    return grasshopperLocations;
  }
}