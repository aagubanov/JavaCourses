public abstract class Piece
{
  private final Color color;

  public Piece(Color color)
  {
    this.color = color;
  }

  private String getColorName()
  {
    return switch (color)
    {
      case Color.WHITE -> getWhiteColorName();
      case Color.BLACK -> getBlackColorName();
    };
  }

  private String getWhiteColorName()
  {
    Gender gender = getGender();
    return switch (gender)
    {
      case Gender.MALE -> "Белый";
      case Gender.FEMALE -> "Белая";
    };
  }

  private String getBlackColorName()
  {
    Gender gender = getGender();
    return switch (gender)
    {
      case Gender.MALE -> "Чёрный";
      case Gender.FEMALE -> "Чёрная";
    };
  }

  public Color getColor()
  {
    return color;
  }

  public abstract Type getType();
  public abstract Gender getGender();

  public String toString()
  {
    String colorName = getColorName();
    Type type = getType();
    return colorName + ' ' + type.toString();
  }
}