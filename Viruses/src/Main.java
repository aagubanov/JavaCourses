void main()
{
  final String INPUT_FILE = "INPUT.txt";
  final String OUTPUT_FILE = "OUTPUT.txt";

  Scanner scanner = tryGetScanner(INPUT_FILE);
  if (scanner == null)
  {
    return;
  }

  Matrix matrix = getMatrix(scanner);
  ArrayList<Cell> infectedCells = getInfectedCells(scanner, matrix);

  int completeInfectionTime = calculateCompleteInfectionTime(matrix, infectedCells);
  saveResult(OUTPUT_FILE, completeInfectionTime);
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

private Matrix getMatrix(Scanner scanner)
{
  int height = scanner.nextInt();
  int width = scanner.nextInt();
  return new Matrix(width, height);
}

private ArrayList<Cell> getInfectedCells(Scanner scanner, Matrix matrix)
{
  ArrayList<Cell> infectedCells = new ArrayList<>();
  int virusCount = scanner.nextInt();

  for (int i = 0; i < virusCount; i++)
  {
    int y = scanner.nextInt() - 1;
    int x = scanner.nextInt() - 1;
    Cell infectedCell = matrix.getCell(x, y);
    infectedCells.add(infectedCell);
  }

  return infectedCells;
}

private int calculateCompleteInfectionTime(Matrix matrix, ArrayList<Cell> infectedCells)
{
  int maxDistanceToInfectionCells = 0;

  for (int y = 0; y < matrix.getHeight(); y++)
  {
    for (int x = 0; x < matrix.getWidth(); x++)
    {
      Cell cell = matrix.getCell(x, y);
      if (cell.isInfected())
      {
        continue;
      }

      int minDistanceToInfectedCell = Integer.MAX_VALUE;
      for (Cell infectedCell : infectedCells)
      {
        int distance = cell.distanceTo(infectedCell);
        minDistanceToInfectedCell = Math.min(minDistanceToInfectedCell, distance);
      }

      maxDistanceToInfectionCells = Math.max(maxDistanceToInfectionCells, minDistanceToInfectedCell);
    }
  }

  return maxDistanceToInfectionCells;
}

private void saveResult(String fileName, int result)
{
  try
  {
    Files.writeString(Path.of(fileName), String.valueOf(result));
  }
  catch (IOException e)
  {
    System.out.printf("ОШИБКА: не удалось записать результат в файл %s\n", fileName);
  }
}