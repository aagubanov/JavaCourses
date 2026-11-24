public class MooreDistanceCalculator implements IDistanceCalculator
{
  @Override
  public double distance(Cell a, Cell b)
  {
    return Math.max(Math.abs(a.x - b.x), Math.abs(a.y - b.y));
  }

  @Override
  public String toString()
  {
    return "Расстояние по Муру = ";
  }
}