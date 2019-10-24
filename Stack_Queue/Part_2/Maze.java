/**
 * <p>Create a 10x10 maze and move character while</p>
 * <p>tracking UNDO and REDO movements</p>
 * <p>Created for CSCI361 at MCLA</p>
 *
 * @author js5986@mcla.edu
 *
 *
 */

import java.util.*;
import java.net.*;
import java.io.*;
import java.net.InetAddress;


public class Maze{
  private static boolean ADMIN = false;
  /*==================================================

                    SETUP

  ==================================================*/

  private static Stack<String> undo_db = new Stack<String>();
  private static Stack<String> redo_db = new Stack<String>();
  private static final List<Integer> valid_moves = new ArrayList<Integer>();
  private static InetAddress localhost;
  private static String publicIP;
  private static String hostname;
  private static Map<String, String> env;
  private static boolean lastVALID = true;
  private static boolean OUCH = false;
  private static boolean DRUNK = false;
  private static int bingeCnt = 0;
  private static int bump = 0;
  private static int Array[][] = new int[10][10];
  private static int x = 0;
  private static int y = 0;
  private static int gCOUNT = 0;
  private static Random randomGenerator = new Random();
/*==================================================

                  INITIALIZE

==================================================*/


  public static void main(String[] args) throws InterruptedException	{
    env = System.getenv();
    for(int i = 0; i <= 9; i++){
      valid_moves.add(i);
    }
    MAP();
  }

/*==================================================

                  GAME LOGIC

==================================================*/

  private static void MAP() throws InterruptedException {

          char Move;
          boolean Running = true;
          Scanner input = new Scanner(System.in);
          // Random random = new Random();
          Array[x][y] = 1;
          print(Array);
          while (Running) {
            Move = input.next().charAt(0);
            gCOUNT++;
            switch (Move) {
              case 'w':
              case 'W':
                  if(checkMove(x -1)){
                    lastVALID = true;
                    Array[x][y] = 0;
                    Array[--x][y] = 1;
                    undo_db.push("U");
                    redo_db.push("U");
                    print(Array);
                    break;
                  }else{
                    lastVALID = false;
                    bump++;
                    print(Array);
                    break;
                  }
              case 's':
              case 'S':
                if(checkMove(x+1)){
                  lastVALID = true;
                  Array[x][y] = 0;
                  Array[++x][y] = 1;
                  undo_db.push("D");
                  redo_db.push("D");
                  print(Array);
                  break;
                }else{
                  lastVALID = false;
                  bump++;
                  print(Array);
                  break;
                }
              case 'd':
              case 'D':
                if(checkMove(y+1)){
                  lastVALID = true;
                  Array[x][y] = 0;
                  Array[x][++y] = 1;
                  undo_db.push("R");
                  redo_db.push("R");
                  print(Array);
                  break;
                }else{
                  lastVALID = false;
                  bump++;
                  print(Array);
                  break;
                }
              case 'a':
              case 'A':
                if(checkMove(y-1)){
                  lastVALID = true;
                  Array[x][y] = 0;
                  Array[x][--y] = 1;
                  undo_db.push("L");
                  redo_db.push("L");
                  print(Array);
                  break;
                }else{
                  lastVALID = false;
                  bump++;
                  print(Array);
                  break;
                }
              case 'u':
              case 'U':
                  GRETEL();
                  break;
              case 'r':
              case 'R':
                  HANSEL();
                  break;
              case 'c':
              case 'C':
                  print(Array);
                  break;
              case 'g':
              case 'G':
                  bingeCnt++;
                  undo_db.push("G");
                  redo_db.clear();
                  redo_db.push("G");
                  DRUNK = true;
                  for(int i =0;i < bingeCnt;i++){
                    Array[x][y]=0;
                    x =randomGenerator.nextInt(10);
                    y = randomGenerator.nextInt(10);
                    Array[x][y] = 1;
                    print(Array);
                    System.out.println("           BLACK OUT MODE!! Please wait for your drunken and rude self....");
                    System.out.println("              The more ya drink the longer it'll last bub.. take it easy");
                    System.out.println("                                  TIMES DRUNK : " + Integer.toString(bingeCnt));
                    Thread.sleep(1000);
                  }
                  print(Array);
                  System.out.println("                                  GULP! Howd I get here!?");
                  break;
              case 'q':
              case 'Q':
                  Running = false;
                  input.close();
                  break;
              default:
                  System.out.println("Please Press Proper Keys!");
                  print(Array);
                  break;
              }
          }
      }


/*==================================================

            ERROR CHECKING FUNCTIONS

==================================================*/

      private static boolean checkMove(int c1){
        if(valid_moves.contains(c1)){
            redo_db.clear();
            return true;
        }else{
          OUCH = true;
          return false;
        }
    	}

/*==================================================

                TRACKING FUNCTIONS

==================================================*/

      //------  REDO
      private static void HANSEL(){
        if(!redo_db.isEmpty()){
          switch(redo_db.pop()){
            case "U":
              Array[x][y] = 0;
              Array[++x][y] = 1;
              print(Array);
              break;
            case "D":
              Array[x][y] = 0;
              Array[--x][y] = 1;
              print(Array);
              break;
            case "L":
              Array[x][y] = 0;
              Array[x][++y] = 1;
              print(Array);
              break;
            case "R":
              Array[x][y] = 0;
              Array[x][--y] = 1;
              print(Array);
              break;
            case "G":
              redo_db.clear();
              DRUNK = false;
              print(Array);
              System.out.println("             BLAH!");
              break;
            default:
              System.out.println("How in the hell!? <- HANSEL()");
              break;
          }
        }else if (x == 0 && y == 0){
          System.out.println("Back to square 1 son");
        }else{
          System.out.println("You done already redid..");
        }
      }


      //------  UNDO
      private static void GRETEL(){
        if(!undo_db.isEmpty()){
          switch(undo_db.pop()){
            case "U":
              if(checkMove(x + 1)){
                Array[x][y] = 0;
                Array[++x][y] = 1;
                print(Array);
                break;
              }
              else{
                break;
              }
            case "D":
              if(checkMove(x -1)){
                Array[x][y] = 0;
                Array[--x][y] = 1;
                print(Array);
                break;
              }else{
                break;
              }
            case "L":
              if(checkMove(y + 1)){
                Array[x][y] = 0;
                Array[x][++y] = 1;
                print(Array);
                break;
              }else{
                break;
              }
            case "R":
              if(checkMove(y - 1)){
                Array[x][y] = 0;
                Array[x][--y] = 1;
                print(Array);
                break;
              }else{
                break;
              }
            case "G":
              DRUNK = false;
              print(Array);
              System.out.println("             BLAH!");
              break;
            default:
              System.out.println("How in the hell!? <- GRETEL()");
              break;
          }
        }
        print(Array);
      }

/*==================================================

                DISPLAY FUNTIONS

==================================================*/
      private static void print(int[][] grid) {
          GFX.clearScreen();
          if(ADMIN){
            STATS();
          }
          if(DRUNK){
            System.out.println("                                      CHEERS PROFESSOR!");
            for(String crazy : GFX.beers){
              System.out.println(crazy);
            }
          }
          HUD();
          System.out.print("\t");
          for (int i = 0; i < grid.length; i++) {
            for (int x = 0; x < grid[0].length; x++) {
                  if(grid[i][x] == 0){
                    System.out.print( "\u001B[46m\u001B[30m   - " + "   \u001b[0m");
                  }else{
                    System.out.print( "\u001b[31m   X " + "   \u001b[0m");
                  }

              }
              System.out.println();
              System.out.print("\t");
          }
          System.out.println();
          MENU();
      }

      private static void HUD(){
        int tmp = undo_db.size()/20;
        List<String> undo_copy;
        undo_copy = undo_db.subList(tmp*20, undo_db.size());
        String hud = GFX.mborder;
        hud += String.format("|%-90s|\n", "                            Welcome to the MAP of DOOM!");
        hud += String.format("|%-90s|\n", "UNDO ->" + undo_copy);
        hud += String.format("|%-90s|\n", "REDO ->" + redo_db);
        hud += GFX.mborder;
        System.out.println(hud);
      }

      private static void MENU(){
        String menu = GFX.mborder;
        menu += String.format("|\u001b[32m%-90.88s\u001b[0m|\n", "                                      WHAT HAVE YOU MAGE?");
        menu += String.format("|\u001b[31m%-90.88s\u001b[0m|\n", "====  LEGACY CONTROLS [ W S A D ] ====");
        menu += String.format("|%-90s|\n", "W: Up");
        menu += String.format("|%-90s|\n", "S: DOWN");
        menu += String.format("|%-90s|\n", "A: RIGHT");
        menu += String.format("|%-90s|\n", "D: LEFT");
        menu += String.format("|\u001b[31m%-90.88s\u001b[0m|\n", "======================================");
        menu += String.format("|%-90s|\n", "");
        menu += String.format("|%-90s|\n", "G: GROG");
        menu += String.format("|%-90s|\n", "U: UNDO");
        menu += String.format("|%-90s|\n", "R: REDO");
        menu += String.format("|%-90s|\n", "Q: QUIT");
        if(OUCH){
          menu += String.format("|%-90.88s|\n", "                                       OUCH!  ");
        }
        menu += GFX.mborder;
        System.out.println(menu);
        OUCH = false;
      }

      private static void STATS(){
        EnvMap();
        IP();
        String stats = "\u001b[34m";
        stats += GFX.mborder;
        stats += String.format("|%-90s|\n", "                                     ADMIN VIEW");
        stats += String.format("|%-90s|\n", " x -> " + Integer.toString(x) + "  y -> " + Integer.toString(y) + "                                        Iteration # " + Integer.toString(gCOUNT));
        stats += String.format("|%-90s\u001B[34m\t\t   |\n", "DRUNK CNT ->  \u001B[31m" + DRUNK + "                             \u001b[33mBINGE CTR -> \u001B[31m" + bingeCnt );
        stats += String.format("|%-90s\u001B[34m\t\t   |\n", "BUMP  CNT ->  \u001B[31m" + bump );
        stats += String.format("|%-90s\u001B[34m\t\t   |\n", "HOSTNAME ->  \u001B[31m" + hostname + "                             \u001b[33mPUBLIC IP -> \u001B[31m" + publicIP );
        stats += "\u001b[0m";
        System.out.print(stats);
      }

      private static void EnvMap() {
              List<String> tmp = new ArrayList<String>(4);
              tmp.add("USER");
              tmp.add("PWD");
              tmp.add("TERM");
              tmp.add("LOGNAME");
              for (String envName : env.keySet()) {
                if(tmp.contains(envName)){
                  System.out.format("%s=%s%n", envName,env.get(envName));
                }
          }
      }


      private static void IP() {
          try
          {
              // Returns the instance of InetAddress containing
              // local host name and address
              localhost = InetAddress.getLocalHost();
              hostname = localhost.getHostName();
              URL url_name = new URL("http://bot.whatismyipaddress.com");
              BufferedReader sc =
              new BufferedReader(new InputStreamReader(url_name.openStream()));
              publicIP = sc.readLine().trim();
          }
          catch (Exception e)
          {
              publicIP = "Cannot Execute Properly";
          }
      }

}
