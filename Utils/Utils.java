import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Utils
{
  private Utils()
  {
  }

  public static String[] readInputFile(String inputFileName, int requiredLinesNumber)
  {
    try
    {
      Path path = Path.of(inputFileName);
      String[] inputLines = Files.readAllLines(path).toArray(new String[0]);

      int linesCount = inputLines.length;
      if (linesCount == 0)
      {
        System.out.printf("ОШИБКА: входной файл %s пуст!\n", inputFileName);
        return null;
      }

      if (linesCount < requiredLinesNumber)
      {
        System.out.printf("ОШИБКА: недостаточное количество данных во входном файле %s!", inputFileName);
        return null;
      }

      return inputLines;
    }
    catch (IOException e)
    {
      System.out.printf("ОШИБКА: входной файл '%s' не найден!\n", inputFileName);
      return null;
    }
  }

  public static int[] getIntegersFromLine(String line, int count)
  {
    return getIntegersFromLine(line, count, null);
  }

  public static int[] getIntegersFromLine(String line, int count, Integer defaultValue)
  {
    String[] numbersAsStrings = line.trim().split("\\s+");
    if (numbersAsStrings.length < count)
    {
      System.out.printf("ОШИБКА: недостаточное количество данных в строке %s!\n", line);
      return null;
    }

    int[] numbers = new int[count];
    for (int i = 0; i < count; i++)
    {
      String numberAsString = numbersAsStrings[i];
      if (defaultValue == null)
      {
        // No way to recover when a string is not a valid integer
        numbers[i] = Integer.parseInt(numberAsString);
      }
      else
      {
        int number;
        try
        {
          number = Integer.parseInt(numberAsString);
        }
        catch (NumberFormatException e)
        {
          // Using the default value as an error mark
          number = defaultValue;
        }

        numbers[i] = number;
      }
    }

    return numbers;
  }

  public static void writeOutputFile(String outputFileName, String outputString)
  {
    try
    {
      Path path = Path.of(outputFileName);

      // Overwrites an existing file
      Files.writeString(path, outputString);
    }
    catch (IOException e)
    {
      System.out.printf("ОШИБКА: не удалось записать в файл '%s'!\n", outputFileName);
    }
  }
}