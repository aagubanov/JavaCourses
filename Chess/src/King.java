public class King extends Piece
{
  public King(Color color)
  {
    super(color);
  }

  public Type getType()
  {
    return Type.KING;
  }

  public Gender getGender()
  {
    return Gender.MALE;
  }
}