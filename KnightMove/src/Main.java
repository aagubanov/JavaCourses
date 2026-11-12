import static java.lang.System.out;

void main()
{
  final String End = "КОНЕЦ";
  Scanner scanner = new Scanner(System.in);

  out.printf("Введите ход коня в полной нотации, например: B1-C3. Введите '%s' для завершения программы\n", End);
  String move = scanner.next();

  while (!move.equalsIgnoreCase(End))
  {
    out.println(ValidateMove(move));
    out.println();
    out.printf("Введите ход коня в полной нотации, например: B1-C3. Введите '%s' для завершения программы\n", End);
    move = scanner.next();
  }
}

private static String ValidateMove(String move)
{
  final String Error = "ERROR";
  final String No = "NO";
  final String Yes = "YES";

  if (!ValidateMoveLength(move))
  {
    return Error;
  }

  if (!ValidateMoveNotation(move))
  {
    return Error;
  }

  if (!ValidateKnightMove(move))
  {
    return No;
  }

  return Yes;
}

private static boolean ValidateMoveLength(String move)
{
  final int MoveLength = 5;
  return move.length() == MoveLength;
}

private static boolean ValidateMoveNotation(String move)
{
  return
    IsValidFile(move.charAt(0)) &&
    IsValidRank(move.charAt(1)) &&
    IsHyphen(move.charAt(2)) &&
    IsValidFile(move.charAt(3)) &&
    IsValidRank(move.charAt(4));
}

private static boolean IsValidFile(char ch)
{
  // Files are named from "a" to "h". Both cases are allowed
  return (ch >= 'A' && ch <= 'H') || (ch >= 'a' && ch <= 'h');
}

private static boolean IsValidRank(char ch)
{
  // Ranks are numbered from 1 to 8
  return ch >= '1' && ch <= '8';
}

private static boolean IsHyphen(char ch)
{
  final char Hyphen = '-';
  return ch == Hyphen;
}

private static boolean ValidateKnightMove(String move)
{
  // A knight's move changes one coordinate by 1 and the other by 2; sum of shifts must be 3
  char originFile = Character.toLowerCase(move.charAt(0));
  char destinationFile = Character.toLowerCase(move.charAt(3));
  int fileShift = Math.abs(destinationFile - originFile);
  if (!ValidateLineShift(fileShift))
  {
    return false;
  }

  // Validated rank numbers are case-insensitive
  int rankShift = Math.abs(move.charAt(1) - move.charAt(4));
  if (!ValidateLineShift(rankShift))
  {
    return false;
  }

  return ValidateTotalShifts(fileShift, rankShift);
}

private static boolean ValidateLineShift(int shift)
{
  return shift >= 1 && shift <= 2;
}

private static boolean ValidateTotalShifts(int fileShift, int rankShift)
{
  final int TotalShift = 3;
  return fileShift + rankShift == TotalShift;
}