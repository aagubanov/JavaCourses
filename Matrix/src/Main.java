void main()
{
  Cell a = new Cell(1, 1);
  Cell b = new Cell(2, 2);

  EuclidDistanceCalculator calculator = new EuclidDistanceCalculator();
  System.out.println("Евклидовское расстояние = " + new EuclidDistanceCalculator().distance(a, b));
  System.out.println("Манхэттенское расстояние = " + new ManhattanDistanceCalculator().distance(a, b));
  System.out.println("Расстояние по Муру = " + new MooreDistanceCalculator().distance(a, b));
}