import java.util.ArrayList;

public class Matrix
{
  private final Cell[][] cells;

  public Matrix(int width, int height)
  {
    cells = new Cell[width][height];

    for (int j = 0; j < height; j++)
    {
      for (int i = 0; i < width; i++)
      {
        cells[i][j] = new Cell(i, j, false);
      }
    }
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

  public ArrayList<Cell> infectedCells()
  {
    ArrayList<Cell> infectedCells = new ArrayList<>();

    for (int j = 0; j < cells[0].length; j++)
    {
      for (int i = 0; i < cells.length; i++)
      {
        if (cells[i][j].getInfected())
        {
          infectedCells.add(cells[i][j]);
        }
      }
    }

    return infectedCells;
  }
}