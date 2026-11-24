void main()
{
  Cell a = new Cell(1, 1);
  Cell b = new Cell(3, 3);

  List<IDistanceCalculator> calculators = List.of(
    new EuclidDistanceCalculator(), new ManhattanDistanceCalculator(), new MooreDistanceCalculator()
  );

  for (IDistanceCalculator calculator : calculators)
  {
    System.out.println(calculator.toString() + calculator.distance(a, b));
  }
}