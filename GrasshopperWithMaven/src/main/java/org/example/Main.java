package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
  static void main()
  {
    final String INPUT_FILE_NAME = "INPUT.TXT";
    final String OUTPUT_FILE_NAME = "OUTPUT.TXT";
    final String GRASSHOPPER_SURVIVED = "YES";

    Scanner scanner = tryGetScanner(INPUT_FILE_NAME);
    if (scanner == null)
    {
      return;
    }

    InputData inputData = fillInputData(scanner);
    if (inputData == null)
    {
      System.out.printf("ОШИБКА: некорректные данные во входном файле %s!\n", INPUT_FILE_NAME);
      return;
    }

    String result = getGrasshopperTravelResult(inputData, GRASSHOPPER_SURVIVED);
    saveResult(OUTPUT_FILE_NAME, result);
  }

  private static Scanner tryGetScanner(String fileName)
  {
    try
    {
      return new Scanner(Path.of(fileName));
    }
    catch (IOException e)
    {
      System.out.printf("ОШИБКА: не удалось прочитать файл %s!\n", fileName);
      return null;
    }
  }

  private static InputData fillInputData(Scanner scanner)
  {
    // First line: a number of grasshopper's jumps; coordinates of a frog; length of a frog's tongue
    if (!scanner.hasNextInt())
    {
      return null;
    }

    // Will be ignored
    int numberOfGrasshopperJumps = scanner.nextInt();
    if (!scanner.hasNextInt())
    {
      return null;
    }

    int frogX = scanner.nextInt();
    if (!scanner.hasNextInt())
    {
      return null;
    }

    int frogY = scanner.nextInt();
    Point frogLocation = new Point(frogX, frogY);
    if (!scanner.hasNextInt())
    {
      return null;
    }

    int frogTongueLength = scanner.nextInt();

    // Next lines: coordinates of grasshopper's jumps
    ArrayList<Point> grasshopperLocations = new ArrayList<>();
    for (int i = 0; i < numberOfGrasshopperJumps; i++)
    {
      if (!scanner.hasNextInt())
      {
        return null;
      }

      int x = scanner.nextInt();

      if (!scanner.hasNextInt())
      {
        return null;
      }

      int y = scanner.nextInt();
      grasshopperLocations.add(new Point(x, y));
    }

    return new InputData(frogLocation, frogTongueLength, grasshopperLocations);
  }

  private static String getGrasshopperTravelResult(InputData inputData, String grasshopperSurvived)
  {
    Point frogLocation = inputData.frogLocation();
    int frogTongueLanguage = inputData.frogTongueLength();
    ArrayList<Point> travelPlan = inputData.grasshopperLocations();

    long numberOfSuccessJumps = travelPlan
      .stream()
      .takeWhile(grasshopperLocation -> grasshopperLocation.distanceTo(frogLocation) > frogTongueLanguage)
      .count();

    // The unfortunate jump should also be added to the result
    return numberOfSuccessJumps == travelPlan.size() ? grasshopperSurvived : String.valueOf(numberOfSuccessJumps + 1);
  }

  private static void saveResult(String fileName, String result)
  {
    try
    {
      Files.writeString(Path.of(fileName), result);
    }
    catch (IOException e)
    {
      System.out.printf("ОШИБКА: не удалось записать результат в файл %s\n", fileName);
    }
  }
}