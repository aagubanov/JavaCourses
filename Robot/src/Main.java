void main()
{
  final String INPUT_FILE = "INPUT.txt";
  final String OUTPUT_FILE = "OUTPUT.txt";

  Scanner scanner = tryGetScanner(INPUT_FILE);
  if (scanner == null)
  {
    return;
  }

  String programCode = readProgram(scanner);
  Program program = new Program(programCode);
  Robot robot = new Robot();

  // The robot executes the complete program anyway
  while (program.hasNextCommand())
  {
    char ch = program.nextCommand();
    robot.execute(ch);
  }

  saveResult(OUTPUT_FILE, robot.getStepsUpToRepeat());
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

private String readProgram(Scanner scanner)
{
  if (!scanner.hasNextLine())
  {
    // Not an error; just an empty program
    return "";
  }

  return scanner.nextLine();
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