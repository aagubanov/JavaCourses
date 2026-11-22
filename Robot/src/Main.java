void main()
{
  String input = "SSLSLSLSSRSRS";
  Robot robot = new Robot();

  int index = 0;
  int commandCount = input.length();

  while (index < commandCount)
  {
    char command = input.charAt(index);
    robot.execute(command);
    index++;
  }

  System.out.println(robot.getStepsUpToRepeat());
}