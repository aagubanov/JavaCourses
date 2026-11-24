void main()
{
  Cell a = new Cell(1, 1);
  Cell b = new Cell(2, 2);

  List<IDistanceCalculator> calculators = List.of(
    new EuclidDistanceCalculator(), new ManhattanDistanceCalculator(), new MooreDistanceCalculator()
  );

  for (IDistanceCalculator calculator : calculators)
  {
    System.out.println(calculator.toString() + calculator.distance(a, b));
  }
}