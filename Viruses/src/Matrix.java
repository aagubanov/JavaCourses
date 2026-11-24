import java.util.ArrayList;

public class Matrix
{
  private final int width;
  private final int height;
  private final Cell[][] cells;

  public Matrix(int width, int height)
  {
    this.width = width;
    this.height = height;

    cells = new Cell[width][height];
    for (int j = 0; j < height; j++)
    {
      for (int i = 0; i < width; i++)
      {
        cells[i][j] = new Cell(i, j, false);
      }
    }
  }

  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
  }

  public Cell getCell(int x, int y)
  {
    return cells[x][y];
  }

  public Cell infectCell(int x, int y)
  {
    Cell cell = cells[x][y];
    cell.infect();
    return cell;
  }
}