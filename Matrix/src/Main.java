void main()
{
  Cell a = new Cell(1, 1);
  Cell b = new Cell(2, 2);

  EuclidDistanceCalculator calculator = new EuclidDistanceCalculator();
  System.out.println("Евклидовское расстояние = " + calculator.distance(a, b));
}