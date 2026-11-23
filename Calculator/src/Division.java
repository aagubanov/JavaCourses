public class Division implements IArithmeticOperation
{
  @Override
  public int apply(int x, int y)
  {
    if (y == 0)
    {
      System.out.println("ОШИБКА: ArithmeticException!");
      return 0;
    }

    return x / y;
  }

  @Override
  public String toString()
  {
    return "X / Y = ";
  }
}