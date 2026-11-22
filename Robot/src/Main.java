void main()
{
  String input = "SSLSLSLSSRSRS";
  Robot robot = new Robot(Direction.FORWARD, new Location(0, 0));

  int index = 0;
  int commandCount = input.length();

  while (!robot.getDeja() && index < commandCount)
  {
    char command = input.charAt(index);
    robot.execute(command);
    index++;
  }

  System.out.println(robot.getSteps());
}