void main()
{
  final String InputFileName = "INPUT.TXT";
  final String OutputFileName = "OUTPUT.TXT";
  final String GrasshopperSurvives = "YES";

  InputData inputData = fillInputData(InputFileName);
  if (inputData == null)
  {
    return;
  }

  Grasshopper grasshopper = new Grasshopper();
  Frog frog = new Frog(inputData.getFrogLocation(), inputData.getFrogTongueLength());

  int fedIndex = 0;
  for (int i = 0; i < inputData.getNumberOfGrasshopperJumps(); i++)
  {
    Point nextLocation = inputData.getGrasshopperLocation(i);
    grasshopper.jumpsTo(nextLocation);

    if (frog.canEat(grasshopper.getLocation()))
    {
      fedIndex = i + 1;
      break;
    }
  }

  // fedIndex == 0 means that the grasshopper has not been fed
  String result = fedIndex > 0 ? String.valueOf(fedIndex) : GrasshopperSurvives;
  writeOutputFile(OutputFileName, result);
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

  // First line: a number of grasshopper's jumps; coordinates of a frog; length of a frog's tongue
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

  int frogX = firstLineNumbers[1];
  int frogY = firstLineNumbers[2];
  inputData.setFrogLocation(new Point(frogX, frogY));

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
    if (coordinates == null || coordinates.length < lineNumbersCount)
    {
      System.out.printf("ОШИБКА: не хватает данных в %d-й строке входного файла!\n", i);
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
    // No way to recover when a string is not a valid integer
    numbers[i] = Integer.parseInt(numbersAsStrings[i]);
  }

  return numbers;
}

private static void writeOutputFile(String outputFileName, String outputString)
{
  try
  {
    Path path = Path.of(outputFileName);

    // Overwrites an existing file
    Files.writeString(path, outputString);
  }
  catch (IOException e)
  {
    System.out.printf("ОШИБКА: не удалось записать в файл '%s'\n", outputFileName);
  }
}