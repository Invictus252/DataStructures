public class Rectangle
{
  private static int r_count;
  private int r_width;
  private int r_height;

  public Rectangle(int width, int height)
  {
      r_width = width;
      r_height = height;
      r_count++;
  }

  public int getWidth()
  {
    return r_width;
  }

  public int getHeight()
  {
    return r_height;
  }

  public int getArea()
  {
    return r_width * r_height;
  }

  public static int getCount()
  {
    return r_count;
  }

  @Override
  public String toString()
  {
    String s = String.format("This rectangle built with width as %s and height as %s", r_width, r_height);
    return s;
  }
}
