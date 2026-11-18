private record Counts(int whitePiecesCount, int pawnsCount)
{
}

void main()
{
  ChessSet chessSet = new ChessSet();
  int numberOfPiecesToTake = getNumberOfPiecesToTake(chessSet.getPiecesCount());

  Counts counts = getAndCountPieces(chessSet.getPieces(), numberOfPiecesToTake);
  printCounts(numberOfPiecesToTake, counts);
}

private static int getNumberOfPiecesToTake(int maxNumberOfPieces)
{
  int numberOfPiecesToTake;

  do
  {
    numberOfPiecesToTake = getIntegerNumberOfPieces();
  }
  while (numberOfPiecesToTake <= 0 || numberOfPiecesToTake > maxNumberOfPieces);

  return numberOfPiecesToTake;
}

private static int getIntegerNumberOfPieces()
{
  Scanner scanner = new Scanner((System.in));

  System.out.print("Введите положительное количество фигур (не больше полного комплекта): ");
  while (!scanner.hasNextDouble())
  {
    scanner.nextLine();
    System.out.print("Введите положительное количество фигур (не больше полного комплекта): ");
  }

  return scanner.nextInt();
}

private static Counts getAndCountPieces(List<Piece> pieces, int numberOfPiecesToTake)
{
  int whitePiecesCount = 0;
  int pawnsCount = 0;

  // Shuffling pieces randomly
  Collections.shuffle(pieces, new Random());

  for (int i = 0; i < numberOfPiecesToTake; i++)
  {
    Piece piece = pieces.get(i);
    System.out.printf("Фигура номер %d: %s\n", i, piece);

    if (piece.getColor() == Color.WHITE)
    {
      whitePiecesCount++;
    }

    if (piece.getType() == Type.PAWN)
    {
      pawnsCount++;
    }
  }

  return new Counts(whitePiecesCount, pawnsCount);
}

private static void printCounts(int numberOfPiecesToTake, Counts counts)
{
  int whitePiecesCount = counts.whitePiecesCount;
  int blackPiecesCount = numberOfPiecesToTake - whitePiecesCount;
  double percentOfBlackPieces = blackPiecesCount * 100.0 / numberOfPiecesToTake;

  double percentOfPawns = counts.pawnsCount * 100.0 / numberOfPiecesToTake;
  double percentOfPieces = 100.0 - percentOfPawns;

  System.out.printf("Количество извлечённых белых фигур: %d\n", whitePiecesCount);
  System.out.printf("Количество извлечённых чёрных фигур: %d\n", blackPiecesCount);
  System.out.printf("Процент извлечённых чёрных фигур: %.2f%n", percentOfBlackPieces);
  System.out.printf("Процент извлечённых пешек: %.2f%n", percentOfPawns);
  System.out.printf("Процент извлечённых фигур: %.2f%n", percentOfPieces);
}