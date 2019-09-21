import java.util.*;

public class Candy3
{
  public static ArrayList<String> candy;
  public static DataStruct newbag;
  private static int ctr;



  public Candy3()
  {
      candy = new ArrayList<String>();
      candy.add("Kit-Kat");
      candy.add("Milky Way");
      candy.add("Lollipop");
      candy.add("Apple");
      candy.add("Gummi Bears");
      candy.add("Snickers");
      ctr = 1;
      newbag = new DataStruct(candy);
  }

    public void run()
    {

        System.out.println(String.format("|%-120s|", "Starting Bucket Contents : " + newbag.toArray().toString()));
        System.out.print(GFX.bborder);
        Random random = new Random();
        int index;
        while(newbag.size() != 1){
          index = random.nextInt(newbag.size());
          System.out.println(String.format("|%-120s|", " Trick or Treater # " + ctr + " picked a " + newbag.get(index)));
          newbag.remove(index);
          ctr++;
        }
        System.out.print(GFX.bborder);
        System.out.println(String.format("|%-120s|", "Ending Bucket Contents : " + newbag.toArray().toString()));
        System.out.print(GFX.bborder);
    }



}
