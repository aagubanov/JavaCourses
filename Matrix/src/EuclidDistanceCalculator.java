public class EuclidDistanceCalculator implements IDistanceCalculator
{
  public double distance(Cell a, Cell b)
  {
    return Math.sqrt(Math.powExact((a.x - b.x), 2) + Math.powExact((a.y - b.y), 2));
  }
}