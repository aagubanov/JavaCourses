void main()
{
  Cell a = new Cell(1, 1, "pink");
  Cell b = new Cell(3, 3, "violet");

  List<IDistanceCalculator> calculators = List.of(
    new EuclidDistanceCalculator(),
    new ManhattanDistanceCalculator(),
    new MooreDistanceCalculator(),
    new EdgeDistanceCalculator()
  );

  for (IDistanceCalculator calculator : calculators)
  {
    System.out.println(calculator.toString() + calculator.distance(a, b));
  }
}