public class Subtraction implements IArithmeticOperation
{
  @Override
  public int apply(int x, int y)
  {
    return x - y;
  }

  @Override
  public String toString()
  {
    return "X - Y = ";
  }
}