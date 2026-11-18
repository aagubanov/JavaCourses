void main()
{
  Scanner scanner = new Scanner((System.in));

  do
  {
    System.out.print("Введите количество фигур (не больше полного комплекта): ");
  }
  while (!scanner.hasNextInt());

  int numberOfTakenPieces = scanner.nextInt();

  ChessSet chessSet = new ChessSet();
  Random random = new Random();
  int[] randomNumbers = random.ints(numberOfTakenPieces, 0, chessSet.getPiecesCount()).toArray();

  for (int i = 0; i < numberOfTakenPieces; i++)
  {
    Piece piece = chessSet.getPiece(randomNumbers[i]);
    System.out.println("Следующая фигура: " + piece);
  }
}