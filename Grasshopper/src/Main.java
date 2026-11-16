void main()
{
  final String InputFileName = "INPUT.TXT";
  final String OutputFileName = "OUTPUT.TXT";

  InputData inputData = fillInputData(InputFileName);
  if (inputData == null)
  {
    return;
  }
}

private static InputData fillInputData(String inputFileName)
{
  String[] inputLines = readInputFile(inputFileName);
  if (inputLines == null)
  {
    System.out.println("ОШИБКА: входной файл не найден!");
    return null;
  }

  int linesCount = inputLines.length;
  if (linesCount == 0)
  {
    System.out.println("ОШИБКА: входной файл пуст!");
    return null;
  }

  InputData inputData = new InputData();

  // First line: a number of grasshopper's jumps; coordinates of his initial position; length of a frog's tongue
  int lineNumbersCount = 4;
  int[] firstLineNumbers = getIntegersFromLine(inputLines[0], lineNumbersCount);

  if (firstLineNumbers == null || firstLineNumbers.length < lineNumbersCount)
  {
    System.out.println("ОШИБКА: не хватает данных в первой строке входного файла!");
    return null;
  }

  int jumpsCount = firstLineNumbers[0];
  if (linesCount <= jumpsCount)
  {
    // Just a warning (we are relying on the lines count)
    System.out.println("ВНИМАНИЕ: количество координат меньше количества прыжков!");
  }

  inputData.setNumberOfGrasshopperJumps(linesCount - 1);

  // Initial grasshopper's coordinates can be ignored
  int frogTongueLength = firstLineNumbers[3];
  if (frogTongueLength <= 0)
  {
    // Just a warning (physically senseless but mathematically possible)
    System.out.println("ВНИМАНИЕ: длина языка лягушки не положительна!");
  }

  inputData.setFrogTongueLength(frogTongueLength);

  // Next lines: coordinates of grasshopper's jumps
  lineNumbersCount = 2;
  for (int i = 1; i < linesCount; i++)
  {
    int[] coordinates = getIntegersFromLine(inputLines[i], lineNumbersCount);
    if (coordinates == null)
    {
      System.out.printf("ОШИБКА: некорректные координаты в строке %d входного файла!\n", i);
      return null;
    }

    int x = coordinates[0];
    int y = coordinates[1];
    Point p = new Point(x, y);
    inputData.addGrasshopperLocation(p);
  }

  return inputData;
}

private static String[] readInputFile(String inputFileName)
{
  try
  {
    Path path = Path.of(inputFileName);
    return Files.readAllLines(path).toArray(new String[0]);
  }
  catch (IOException e)
  {
    return null;
  }
}

private static int[] getIntegersFromLine(String line, int count)
{
  String[] numbersAsStrings = line.trim().split("\\s+");
  if (numbersAsStrings.length < count)
  {
    return null;
  }

  int[] numbers = new int[count];
  for (int i = 0; i < count; i++)
  {
    numbers[i] = tryParseInt(numbersAsStrings[i]);
  }

  return numbers;
}

private static int tryParseInt(String intAsString)
{
  try
  {
    return Integer.parseInt((intAsString));
  }
  catch (NumberFormatException e)
  {
    return -1;
  }
}