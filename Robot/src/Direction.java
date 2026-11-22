public enum Direction
{
  FORWARD,
  RIGHT,
  BACKWARD,
  LEFT;

  private static final Direction[] VALUES = values();
  private static final int LENGTH = VALUES.length;

  public Direction next()
  {
    return VALUES[(this.ordinal() + 1) % LENGTH];
  }

  public Direction previous()
  {
    // Adding the enum length to avoid negative numbers
    return VALUES[(this.ordinal() + LENGTH - 1) % LENGTH];
  }
}