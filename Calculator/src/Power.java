public class Power implements IArithmeticOperation
{
  @Override
  public int apply(int x, int y)
  {
    return Math.powExact(x, y);
  }

  @Override
  public String toString()
  {
    return "X в степени Y = ";
  }
}