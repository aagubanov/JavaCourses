void main()
{
  Scanner scanner = new Scanner(System.in);

  System.out.print("Введите целое число X: ");
  int x = scanner.nextInt();

  System.out.print("Введите целое число Y: ");
  int y = scanner.nextInt();

  List<IArithmeticOperation> operations = List.of(
    new Addition(), new Subtraction(), new Multiplication(), new Division(), new Power()
  );

  for (IArithmeticOperation operation : operations)
  {
    System.out.println(operation.toString() + operation.apply(x, y));
  }
}