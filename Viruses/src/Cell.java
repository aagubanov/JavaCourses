public class Cell
{
  private final int x;
  private final int y;
  private boolean infected;

  public Cell(int x, int y, boolean infected)
  {
    this.x = x;
    this.y = y;
    this.infected = infected;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public boolean getInfected()
  {
    return infected;
  }

  public void infect()
  {
    infected = true;
  }

  @Override
  public String toString()
  {
    return "[" + (y + 1) + ", " + (x + 1) + "]";
  }
}