public class Bishop extends Piece
{
  public Bishop(Color color)
  {
    super(color);
  }

  public Type getType()
  {
    return Type.BISHOP;
  }

  public Gender getGender()
  {
    return Gender.MALE;
  }
}