import java.util.*;

public class Candy2
{
  private static int ctr;
  public static ArrayList<String> candy;

  public Candy2()
  {
      candy = new ArrayList<String>();
      candy.add("Kit-Kat");
      candy.add("Milky Way");
      candy.add("Lollipop");
      candy.add("Apple");
      candy.add("Gummi Bears");
      candy.add("Snickers");
      ctr = 1;
  }

    public void run()
    {
      System.out.println(String.format("|%-120s|", "Starting Bucket Contents : " + candy.toString()));
      System.out.print(GFX.bborder);
      Random random = new Random();
      int index;
      while(candy.size() != 1){
        index = random.nextInt(candy.size());
        System.out.println(String.format("|%-120s|", " Trick or Treater # " + ctr + " picked a " + candy.get(index)));
        candy.remove(index);
        ctr++;
      }
      System.out.print(GFX.bborder);
      System.out.println(String.format("|%-120s|", "Ending Bucket Contents : " + candy.toString()));
      System.out.print(GFX.bborder);
    }
}
