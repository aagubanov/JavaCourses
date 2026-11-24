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

  public void infect()
  {
    infected = true;
  }

  public boolean isInfected()
  {
    return infected;
  }

  public int distanceTo(Cell cell)
  {
    return Math.abs(x - cell.getX()) + Math.abs(y - cell.getY());
  }
}