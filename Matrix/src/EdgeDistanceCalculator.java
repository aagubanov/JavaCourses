public class EdgeDistanceCalculator implements IDistanceCalculator
{
  @Override
  public double distance(Cell a, Cell b)
  {
    int dx = Math.max(0, Math.abs(a.x - b.x) - 1);
    int dy = Math.max(0, Math.abs(a.y - b.y) - 1);
    return Math.max(dx, dy);
  }

  @Override
  public String toString()
  {
    return "Минимальное расстояние между углами = ";
  }
}