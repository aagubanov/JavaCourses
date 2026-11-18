import java.util.ArrayList;
import java.util.List;

public class ChessSet
{
  private final int numberOfPieces = 32;
  private final List<Piece> pieces = new ArrayList<>(numberOfPieces);

  public ChessSet()
  {
    createPieces();
  }

  private void createPiece(Color color, Type type)
  {
    switch (type)
    {
      case Type.KING -> pieces.add(new King(color));
      case Type.QUEEN -> pieces.add(new Queen(color));
      case Type.ROOK -> pieces.add(new Rook(color));
      case Type.BISHOP -> pieces.add(new Bishop(color));
      case Type.KNIGHT -> pieces.add(new Knight(color));
      case Type.PAWN -> pieces.add(new Pawn(color));
    }
    ;
  }

  private void createPiecesOfType(Color color, Type type, int number)
  {
    for (int i = 0; i < number; i++)
    {
      createPiece(color, type);
    }
  }

  private void createPiecesOfColor(Color color)
  {
    createPiecesOfType(color, Type.KING, 1);
    createPiecesOfType(color, Type.QUEEN, 1);
    createPiecesOfType(color, Type.ROOK, 2);
    createPiecesOfType(color, Type.BISHOP, 2);
    createPiecesOfType(color, Type.KNIGHT, 2);
    createPiecesOfType(color, Type.PAWN, 8);
  }

  private void createPieces()
  {
    createPiecesOfColor(Color.WHITE);
    createPiecesOfColor(Color.BLACK);
  }

  public int getPiecesCount()
  {
    return numberOfPieces;
  }

  public List<Piece> getPieces()
  {
    return pieces;
  }

  public Piece getPiece(int index)
  {
    return pieces.get(index);
  }
}