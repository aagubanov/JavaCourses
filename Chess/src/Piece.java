public abstract class Piece
{
  private final Color color;

  public Piece(Color color)
  {
    this.color = color;
  }

  public Color getColor()
  {
    return color;
  }

  public abstract Type getType();

  public String toString()
  {
    Type type = getType();
    return color.toString() + ' ' + type.toString();
  }
}