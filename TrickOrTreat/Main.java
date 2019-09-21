import java.util.*;

public class Main
{
    private static Scanner in = new Scanner(System.in);
    private static Boolean run = true;
    public static void main(String args[])
    {
        while(run){
          String menu;
          HUD();
          String ans = holdup();
          switch(ans){
            case "1":
              menu = "";
              Candy1 candy1 = new Candy1();
              menu = GFX.bborder;
              menu += String.format("|%-120.25s|\n", "  Candy1.java ");
              menu += GFX.bborder;
              GFX.clearScreen();
              System.out.print(menu);
              vBucket(candy1.candy);
              System.out.print(GFX.bborder);
              candy1.run();
              vBucket(candy1.candy);
              System.out.print(GFX.bborder);
              ans=holdup();
              break;
            case "2":
              menu = "";
              Candy2 candy2 = new Candy2();
              menu = GFX.bborder;
              menu += String.format("|%-120.25s|\n", "  Candy2.java ");
              menu += GFX.bborder;
              GFX.clearScreen();
              System.out.print(menu);
              vBucket(candy2.candy);
              System.out.print(GFX.bborder);
              candy2.run();
              vBucket(candy2.candy);
              System.out.print(GFX.bborder);
              ans=holdup();
              break;
            case "3":
              menu = "";
              Candy3 candy3 = new Candy3();
              menu = GFX.bborder;
              menu += String.format("|%-120.25s|\n", "  Candy3.java ");
              menu += GFX.bborder;
              GFX.clearScreen();
              System.out.print(menu);
              vBucket(candy3.newbag.toArray());
              System.out.print(GFX.bborder);
              candy3.run();
              vBucket(candy3.newbag.toArray());
              System.out.print(GFX.bborder);
              ans = holdup();
              break;
            case "_42":
              GFX.clearScreen();
              for (String x : GFX._42){
                System.out.println(x);
              }
            case "x":
              run = false;
              break;
            default:
              break;
          }
        }
    }

    public static void HUD(){
      String menu = GFX.mborder;
      String ans = "";
      GFX.clearScreen();
      menu += String.format("|%-28.25s|\n", "Welcome to my Homework!");
      menu += GFX.mborder;
      menu += String.format("|%-28.25s|\n", "...would you like to play");
      menu += String.format("|%-28.25s|\n", "a game Professor Cohen?..");
      menu += GFX.mborder;
      menu += String.format("|%-28.25s|\n", "Candy1().java <---  1 ");
      menu += String.format("|%-28.25s|\n", "Candy2().java <---  2 ");
      menu += String.format("|%-28.25s|\n", "Candy3().java <---  3 ");
      menu += String.format("|%-28.25s|\n", "The answer to life,   ");
      menu += String.format("|%-28.25s|\n", "the universe and      ");
      menu += String.format("|%-28.25s|\n", "      everything   _42");
      menu += String.format("|%-28.25s|\n", "  x || X  --->  EXIT  ");
      menu += GFX.mborder;
      System.out.println(menu);
    }

    public static String holdup(){
      System.out.println("Press any key to proceed");
      String wait;
      wait = in.nextLine();
      return wait;
    }

    public static void vBucket(String[] build){
      String[] bucket = new String[]{"","","","",""};
      for (String x : build){
        switch(x){
          case "Kit-Kat":
            bucket[0] += GFX.pumpKK[0] +"  ";
            bucket[1] += GFX.pumpKK[1] +"  ";
            bucket[2] += GFX.pumpKK[2] +"  ";
            bucket[3] += GFX.pumpKK[3] +"  ";
            bucket[4] += GFX.pumpKK[4] +"  ";
            break;
          case "Snickers":
            bucket[0] += GFX.pumpSN[0] +"  ";
            bucket[1] += GFX.pumpSN[1] +"  ";
            bucket[2] += GFX.pumpSN[2] +"  ";
            bucket[3] += GFX.pumpSN[3] +"  ";
            bucket[4] += GFX.pumpSN[4] +"  ";
            break;
          case "Milky Way":
            bucket[0] += GFX.pumpMW[0] +"  ";
            bucket[1] += GFX.pumpMW[1] +"  ";
            bucket[2] += GFX.pumpMW[2] +"  ";
            bucket[3] += GFX.pumpMW[3] +"  ";
            bucket[4] += GFX.pumpMW[4] +"  ";
            break;
          case "Gummi Bears":
            bucket[0] += GFX.pumpGB[0] +"  ";
            bucket[1] += GFX.pumpGB[1] +"  ";
            bucket[2] += GFX.pumpGB[2] +"  ";
            bucket[3] += GFX.pumpGB[3] +"  ";
            bucket[4] += GFX.pumpGB[4] +"  ";
            break;
          case "Lollipop":
            bucket[0] += GFX.pumpDD[0] +"  ";
            bucket[1] += GFX.pumpDD[1] +"  ";
            bucket[2] += GFX.pumpDD[2] +"  ";
            bucket[3] += GFX.pumpDD[3] +"  ";
            bucket[4] += GFX.pumpDD[4] +"  ";
            break;
          case "Apple":
            bucket[0] += GFX.pumpAP[0] +"  ";
            bucket[1] += GFX.pumpAP[1] +"  ";
            bucket[2] += GFX.pumpAP[2] +"  ";
            bucket[3] += GFX.pumpAP[3] +"  ";
            bucket[4] += GFX.pumpAP[4] +"  ";
            break;
          default:
            break;
        }
      }
      System.out.println(String.format("|%-120s|", bucket[0]));
      System.out.println(String.format("|%-120s|", bucket[1]));
      System.out.println(String.format("|%-120s|", bucket[2]));
      System.out.println(String.format("|%-120s|", bucket[3]));
      System.out.println(String.format("|%-120s|", bucket[4]));
    }

    public static void vBucket(ArrayList<String> build){
      String[] bucket = new String[]{"","","","",""};
      for (String x : build){
        switch(x){
          case "Kit-Kat":
            bucket[0] += GFX.pumpKK[0] +"  ";
            bucket[1] += GFX.pumpKK[1] +"  ";
            bucket[2] += GFX.pumpKK[2] +"  ";
            bucket[3] += GFX.pumpKK[3] +"  ";
            bucket[4] += GFX.pumpKK[4] +"  ";
            break;
          case "Snickers":
            bucket[0] += GFX.pumpSN[0] +"  ";
            bucket[1] += GFX.pumpSN[1] +"  ";
            bucket[2] += GFX.pumpSN[2] +"  ";
            bucket[3] += GFX.pumpSN[3] +"  ";
            bucket[4] += GFX.pumpSN[4] +"  ";
            break;
          case "Milky Way":
            bucket[0] += GFX.pumpMW[0] +"  ";
            bucket[1] += GFX.pumpMW[1] +"  ";
            bucket[2] += GFX.pumpMW[2] +"  ";
            bucket[3] += GFX.pumpMW[3] +"  ";
            bucket[4] += GFX.pumpMW[4] +"  ";
            break;
          case "Gummi Bears":
            bucket[0] += GFX.pumpGB[0] +"  ";
            bucket[1] += GFX.pumpGB[1] +"  ";
            bucket[2] += GFX.pumpGB[2] +"  ";
            bucket[3] += GFX.pumpGB[3] +"  ";
            bucket[4] += GFX.pumpGB[4] +"  ";
            break;
          case "Lollipop":
            bucket[0] += GFX.pumpDD[0] +"  ";
            bucket[1] += GFX.pumpDD[1] +"  ";
            bucket[2] += GFX.pumpDD[2] +"  ";
            bucket[3] += GFX.pumpDD[3] +"  ";
            bucket[4] += GFX.pumpDD[4] +"  ";
            break;
          case "Apple":
            bucket[0] += GFX.pumpAP[0] +"  ";
            bucket[1] += GFX.pumpAP[1] +"  ";
            bucket[2] += GFX.pumpAP[2] +"  ";
            bucket[3] += GFX.pumpAP[3] +"  ";
            bucket[4] += GFX.pumpAP[4] +"  ";
            break;
          default:
            break;
        }
      }
      System.out.println(String.format("|%-120s|", bucket[0]));
      System.out.println(String.format("|%-120s|", bucket[1]));
      System.out.println(String.format("|%-120s|", bucket[2]));
      System.out.println(String.format("|%-120s|", bucket[3]));
      System.out.println(String.format("|%-120s|", bucket[4]));
    }

    public static void vBucket(List<String> build){
      String[] bucket = new String[]{"","","","",""};
      for (String x : build){
        switch(x){
          case "Kit-Kat":
            bucket[0] += GFX.pumpKK[0] +"  ";
            bucket[1] += GFX.pumpKK[1] +"  ";
            bucket[2] += GFX.pumpKK[2] +"  ";
            bucket[3] += GFX.pumpKK[3] +"  ";
            bucket[4] += GFX.pumpKK[4] +"  ";
            break;
          case "Snickers":
            bucket[0] += GFX.pumpSN[0] +"  ";
            bucket[1] += GFX.pumpSN[1] +"  ";
            bucket[2] += GFX.pumpSN[2] +"  ";
            bucket[3] += GFX.pumpSN[3] +"  ";
            bucket[4] += GFX.pumpSN[4] +"  ";
            break;
          case "Milky Way":
            bucket[0] += GFX.pumpMW[0] +"  ";
            bucket[1] += GFX.pumpMW[1] +"  ";
            bucket[2] += GFX.pumpMW[2] +"  ";
            bucket[3] += GFX.pumpMW[3] +"  ";
            bucket[4] += GFX.pumpMW[4] +"  ";
            break;
          case "Gummi Bears":
            bucket[0] += GFX.pumpGB[0] +"  ";
            bucket[1] += GFX.pumpGB[1] +"  ";
            bucket[2] += GFX.pumpGB[2] +"  ";
            bucket[3] += GFX.pumpGB[3] +"  ";
            bucket[4] += GFX.pumpGB[4] +"  ";
            break;
          case "Lollipop":
            bucket[0] += GFX.pumpDD[0] +"  ";
            bucket[1] += GFX.pumpDD[1] +"  ";
            bucket[2] += GFX.pumpDD[2] +"  ";
            bucket[3] += GFX.pumpDD[3] +"  ";
            bucket[4] += GFX.pumpDD[4] +"  ";
            break;
          case "Apple":
            bucket[0] += GFX.pumpAP[0] +"  ";
            bucket[1] += GFX.pumpAP[1] +"  ";
            bucket[2] += GFX.pumpAP[2] +"  ";
            bucket[3] += GFX.pumpAP[3] +"  ";
            bucket[4] += GFX.pumpAP[4] +"  ";
            break;
          default:
            break;
        }
      }
      System.out.println(String.format("|%-120s|", bucket[0]));
      System.out.println(String.format("|%-120s|", bucket[1]));
      System.out.println(String.format("|%-120s|", bucket[2]));
      System.out.println(String.format("|%-120s|", bucket[3]));
      System.out.println(String.format("|%-120s|", bucket[4]));
    }
}
