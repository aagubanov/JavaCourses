import java.util.Scanner;

public class Gubanov
{
  private record Item (double mass, double volume)
  {
    public double density()
    {
      if (volume != 0)
      {
        return mass / volume;
      }

      // Black holes and photons are allowed
      return mass > 0 ? Double.POSITIVE_INFINITY : 0;
    }
  }

  public static void main()
  {
    // Reusing a scanner between tasks
    Scanner scanner = new Scanner(System.in);

    System.out.println("--- Задача двух тел ---");
    System.out.println();
    twoItemsTask(scanner);

    System.out.println();
    System.out.println();
    System.out.println("--- Задача трёх тел ---");
    System.out.println();
    threeItemsTask(scanner);

    System.out.println();
    System.out.println();
    System.out.println("--- Задача пяти тел ---");
    System.out.println();
    fiveItemsTask(scanner);
  }

  private static void twoItemsTask(Scanner scanner)
  {
    Item[] items = getItems(scanner, 2);

    double maxDensity = Math.max(items[0].density(), items[1].density());
    System.out.printf("Максимальная плотность для данных предметов равна %s", formatDensity(maxDensity));
  }

  private static void threeItemsTask(Scanner scanner)
  {
    Item[] items = getItems(scanner, 3);

    double density1 = items[0].density();
    double density2 = items[1].density();
    double density3 = items[2].density();

    int counter = 0;
    if (Double.compare(density1, density2) == 0)
    {
      counter++;
    }

    if (Double.compare(density1, density3) == 0)
    {
      counter++;
    }

    if (Double.compare(density2, density3) == 0)
    {
      counter++;
    }

    if (counter == 3)
    {
      System.out.print("Все плотности равны");
    }
    else if (counter == 1)
    {
      System.out.print("Две плотности равны");
    }
    else
    {
      System.out.print("Плотности разные");
    }
  }

  private static void fiveItemsTask(Scanner scanner)
  {
    Item[] items = getItems(scanner, 5);

    double totalMass = 0;
    double totalVolume = 0;

    // Weighted average is calculated
    for (int i = 0; i < 5; i++)
    {
      Item item = items[i];
      totalMass += item.mass();
      totalVolume += item.volume();
    }

    double meanDensity = totalMass / totalVolume;
    System.out.printf("Средняя (по объёму) плотность для данных предметов равна %s", formatDensity(meanDensity));
  }

  private static Item[] getItems(Scanner scanner, int count)
  {
    Item[] items = new Item[count];

    for (int i = 0; i < count; i++)
    {
      Item item = readItemProperties(scanner, i);
      items[i] = item;
    }

    return items;
  }

  private static Item readItemProperties(Scanner scanner, int index)
  {
    int order = index + 1;

    System.out.printf("Введите массу %d-го предмета: ", order);
    double mass = scanner.nextDouble();
    while (mass < 0)
    {
      System.out.printf("Введите неотрицательную массу %d-го предмета: ", order);
      mass = scanner.nextDouble();
    }

    System.out.printf("Введите объём %d-го предмета: ", order);
    double volume = scanner.nextDouble();
    while (volume < 0)
    {
      System.out.printf("Введите неотрицательный объём %d-го предмета: ", order);
      volume = scanner.nextDouble();
    }

    return new Item(mass, volume);
  }

  private static String formatDensity(double density)
  {
    return Double.isInfinite(density) ? "бесконечности" : String.format("%.3f", density);
  }
}