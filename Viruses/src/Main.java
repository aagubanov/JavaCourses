void main()
{
  final String INPUT_FILE = "INPUT.txt";
  final String OUTPUT_FILE = "OUTPUT.txt";

  Scanner scanner = tryGetScanner(INPUT_FILE);
  if (scanner == null)
  {
    return;
  }

  int height = scanner.nextInt();
  int width = scanner.nextInt();

  Matrix matrix = new Matrix(width, height);
  ArrayList<Cell> infectedCells = new ArrayList<>();

  int virusCount = scanner.nextInt();
  for (int i = 0; i < virusCount; i++)
  {
    int y = scanner.nextInt() - 1;
    int x = scanner.nextInt() - 1;
    Cell infectedCell = matrix.infectCell(x, y);
    infectedCells.add(infectedCell);
  }

  int time = 0;

  for (int y = 0; y < height; y++)
  {
    for (int x = 0; x < width; x++)
    {
      int minDistance = Integer.MAX_VALUE;

      for (Cell infectedCell : infectedCells)
      {
        int distance = Math.abs(x - infectedCell.getX()) + Math.abs(y - infectedCell.getY());
        minDistance = Math.min(minDistance, distance);
      }

      time = Math.max(time, minDistance);
    }
  }

  System.out.println("time = " + time);
}

private Scanner tryGetScanner(String fileName)
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

private ArrayList<Cell> initState(Scanner scanner)
{
  int height = scanner.nextInt();
  int width = scanner.nextInt();
  Matrix matrix = new Matrix(width, height);

  int virusCount = scanner.nextInt();
  for (int i = 0; i < virusCount; i++)
  {
    int y = scanner.nextInt() - 1;
    int x = scanner.nextInt() - 1;
    matrix.infectCell(x, y);
  }

  ArrayList<Cell> infectedCells = new ArrayList<>();
  for (int i = 0; i < width; i++)
  {
    for (int j = 0; j < height; j++)
    {
      Cell cell = matrix.getCell(i, j);
      if (cell.getInfected())
      {
        infectedCells.add(cell);
      }
      else
      {
      }
    }
  }

  return infectedCells;
}