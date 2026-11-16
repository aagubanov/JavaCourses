void main()
{
  Point point1 = new Point(0, 0);
  Point point2 = new Point(5, 12);

  System.out.println("Distance is: " + Point.distance(point1, point2));

  Frog frog = new Frog(new Point(0, 1), 10);
  System.out.println("Frog is " + Point.distance(point1, frog.getLocation()) + " away");
  System.out.println("Tongue length is: " + frog.getTongueLength());

  Grasshopper grasshopper = new Grasshopper(new Point(0, 0));
  grasshopper.jumpTo(new Point(0, -9));
  System.out.println("Grasshopper is fed: " + grasshopper.isFed(frog.getLocation(), frog.getTongueLength()));
}