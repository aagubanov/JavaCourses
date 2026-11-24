public class ManhattanDistanceCalculator implements IDistanceCalculator
{
  @Override
  public double distance(Cell a, Cell b)
  {
    return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
  }
}