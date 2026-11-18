public class Queen extends Piece
{
  public Queen(Color color)
  {
    super(color);
  }

  public Type getType()
  {
    return Type.QUEEN;
  }

  public Gender getGender()
  {
    return Gender.MALE;
  }
}