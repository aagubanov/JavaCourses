void main()
{
  final String InputFileName = "INPUT.TXT";
  final String OutputFileName = "OUTPUT.TXT";

  List<String> inputLines = readInputFile(InputFileName);
  if (inputLines == null)
  {
    writeOutputFile(OutputFileName, "ОШИБКА: не удалось прочитать файл '%s'".formatted(InputFileName));
    return;
  }

  if (inputLines.isEmpty())
  {
    writeOutputFile(OutputFileName, "ОШИБКА: файл '%s' пустой".formatted(InputFileName));
    return;
  }

  String firstLine = inputLines.getFirst();
  Map.Entry<Integer, Integer> tunnelsAndCrossroads = getPairOfNumbers(firstLine);
  if (tunnelsAndCrossroads == null)
  {
    writeOutputFile(OutputFileName, "ОШИБКА: файл '%s' содержит некорректные данные в 1-й строке".formatted(InputFileName));
    return;
  }

  int tunnelCount = tunnelsAndCrossroads.getValue();
  if (inputLines.size() < tunnelCount + 1)
  {
    writeOutputFile(OutputFileName, "ОШИБКА: список туннелей в файле '%s' неполный".formatted(InputFileName));
    return;
  }

  int crossroadCount = tunnelsAndCrossroads.getKey();
  if (tunnelCount > crossroadCount * (crossroadCount - 1) / 2)
  {
    writeOutputFile(OutputFileName, "ОШИБКА: количество туннелей слишком велико для данного количества перекрёстков");
    return;
  }

  // An array is initialized with zeroes
  int[] trafficLightCounts = new int[crossroadCount];

  // Loop over the remaining file lines
  for (int i = 1; i <= tunnelCount; i++)
  {
    String nextLine = inputLines.get(i);
    Map.Entry<Integer, Integer> tunnelCrossroads = getPairOfNumbers(nextLine);
    if (tunnelCrossroads == null)
    {
      writeOutputFile(OutputFileName, "ОШИБКА: некорректное описание туннеля в строке %d файла '%s'".formatted(i + 1, InputFileName));
      return;
    }

    // Every tunnel means one traffic light per either of crossroads
    int firstCrossroad = tunnelCrossroads.getKey();
    trafficLightCounts[firstCrossroad - 1]++;

    int secondCrossroad = tunnelCrossroads.getValue();
    trafficLightCounts[secondCrossroad - 1]++;
  }

  StringJoiner joiner = new StringJoiner(" ");
  for (int count : trafficLightCounts)
  {
    joiner.add(Integer.toString(count));
  }

  writeOutputFile(OutputFileName, joiner.toString());
}

private static List<String> readInputFile(String inputFileName)
{
  try
  {
    Path path = Path.of(inputFileName);
    return Files.readAllLines(path);
  }
  catch (IOException e)
  {
    return null;
  }
}

private static Map.Entry<Integer, Integer> getPairOfNumbers(String line)
{
  String[] numbersAsStrings = line.trim().split("\\s+");
  if (numbersAsStrings.length < 2)
  {
    return null;
  }

  int firstNumber = tryParseInt(numbersAsStrings[0]);
  if (firstNumber <= 0)
  {
    return null;
  }

  int secondNumber = tryParseInt(numbersAsStrings[1]);
  if (secondNumber <= 0)
  {
    return null;
  }

  return Map.entry(firstNumber, secondNumber);
}

private static int tryParseInt(String intAsString)
{
  try
  {
    return Integer.parseInt((intAsString));
  }
  catch (NumberFormatException e)
  {
    // 0 is a safe error value, as valid numbers must be positive
    return 0;
  }
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