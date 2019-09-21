import java.util.*;

public class Candy1
{
    private static int ctr;
    public static String[] candy;

    public Candy1()
    {
        candy = new String[]{"Kit-Kat","Apple","Snickers","Milky Way","Gummi Bears","Lollipop"} ;
        ctr = 0;
    }

    public void run()
    {
      System.out.println(String.format("|%-120s|", "Starting Bucket Contents : " + Arrays.toString(candy)));
      Random random = new Random();
      int index;
      while(getNullCount() != 5){
        index = random.nextInt(candy.length);
        while(!candy[index].equals("")){
          System.out.println(String.format("|%-120s|", " Trick or Treater # " + (ctr+1) + " picked a " + candy[index]));
          candy[index] = "";
      }}
      System.out.print(GFX.bborder);
      System.out.println(String.format("|%-120s|", "Ending Bucket Contents : " + Arrays.toString(candy)));
      System.out.print(GFX.bborder);
    }

    public static int getNullCount(){
      ctr = 0;
      for( String x : candy){
        if(x.equals(""))
          ctr++;
      }
      return ctr;
    }
}
