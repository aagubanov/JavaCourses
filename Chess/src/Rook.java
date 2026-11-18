public class Rook extends Piece
{
  public Rook(Color color)
  {
    super(color);
  }

  public Type getType()
  {
    return Type.ROOK;
  }

  public Gender getGender()
  {
    return Gender.FEMALE;
  }
}