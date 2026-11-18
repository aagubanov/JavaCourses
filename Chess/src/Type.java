public enum Type
{
  PAWN,
  KNIGHT,
  BISHOP,
  ROOK,
  QUEEN,
  KING;

  @Override
  public String toString() {
    return switch(this)
    {
      case PAWN -> "пешка";
      case KNIGHT -> "конь";
      case BISHOP -> "слон";
      case ROOK -> "ладья";
      case QUEEN -> "ферзь";
      case KING -> "король";
    };
  }
}