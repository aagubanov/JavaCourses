public class Pawn extends Piece
{
  public Pawn(Color color)
  {
    super(color);
  }

  public Type getType()
  {
    return Type.PAWN;
  }

  public Gender getGender()
  {
    return Gender.FEMALE;
  }
}