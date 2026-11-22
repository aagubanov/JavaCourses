public class Program
{
  private final String commandList;
  private int position;

  public Program(String commandList)
  {
    this.commandList = commandList;
    position = 0;
  }

  public boolean hasNextCommand()
  {
    return position < commandList.length();
  }

  public char nextCommand()
  {
    return commandList.charAt(position++);
  }
}