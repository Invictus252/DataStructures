import java.util.Scanner;

public class Recursion
{
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args)
	{
    while (true){
			GFX.clearScreen();
			HUD();
			System.out.println("Enter your choice");
			String ans = in.next();
      switch(ans){
        case "1":
					System.out.println(" Set 1 [2,7] Run 1 -> returns -3");
					System.out.println(" Set 2 [5,3] Run 1 -> @ 5");
					System.out.println(" Set 2 [5,3] Run 2 -> @ 2");
					System.out.println(" Set 2 [5,3] Run 3 -> returns 0");
					System.out.println(" Set 3 [15,3] Run 1 -> @ 15");
					System.out.println(" Set 3 [15,3] Run 2 -> @ 12");
					System.out.println(" Set 3 [15,3] Run 3 -> @ 6");
					System.out.println(" Set 3 [15,3] Run 4 -> returns 0");
          int[][] inArray1 = {{2,7},{5,3},{15,3}};
          System.out.println("Process 1");
          for (int[] x : inArray1){
            int out1 = fooOne(x[0],x[1]);
            System.out.println(out1 );
            }
					holdup();
          break;
        case "2":
					System.out.println(" Set 1 [10,4] Run 1 -> @ 110");
					System.out.println(" Set 1 [10,4] Run 2 -> returns -1");
					System.out.println(" Set 2 [4,3] Run 2 -> @ 20");
					System.out.println(" Set 2 [4,3] Run 3 -> returns -1");
					System.out.println(" Set 3 [4,7] Run 1 -> @ 20");
					System.out.println(" Set 3 [5,7] Run 2 -> @ 30");
					System.out.println(" Set 3 [6,7] Run 3 -> @ 42");
					System.out.println(" Set 3 [7,7] Run 4 -> @ 56");
					System.out.println(" Set 4 [8,7] Run 4 -> returns 120");
          int[][] inArray2 = {{10,4},{4,3},{4,7}};
          System.out.println("Process 2");
          for (int[] x : inArray2){
            int out2 = fooTwo(x[0],x[1]);
            System.out.println(out2);
          }
					holdup();
          break;
        case "3":
					three();
          break;
        case "4":
				  int[] tmp = four();
					System.out.println("nCk -> " + Integer.toString(nCk(tmp[0],tmp[1])));
					holdup();
          break;
        case "x":
        case "X":
          System.exit(0);
        case "42":
          GFX.clearScreen();
          for (String x : GFX._42){
            System.out.println(x);
          }
          System.exit(0);
        default:
          break;
      }
    }

	}


  public static void HUD()
	{
    String menu = GFX.mborder;
    String ans = "";
    menu += String.format("|%-45.44s|\n", "Welcome to my Recursive(Homework) Homework!");
    menu += GFX.mborder;
    menu += String.format("|%45.33s|\n", "Answer 1 <---  1 ");
    menu += String.format("|%45.33s|\n", "Answer 2 <---  2 ");
    menu += String.format("|%45.33s|\n", "Run Problem Program 3 <---  3 ");
    menu += String.format("|%45.33s|\n", "Run Problem Program 4 <---  4 ");
    menu += String.format("|%45.33s|\n", "The answer to life,   ");
    menu += String.format("|%45.33s|\n", "the universe and      ");
    menu += String.format("|%45.33s|\n", "      everything   42 ");
    menu += String.format("|%45.33s|\n", "EXIT         x|X ");
    menu += GFX.mborder;
    System.out.println(menu);
  }

  public static void holdup()
	{
		System.out.println("Press \"ENTER\" to continue...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

  public static int fooOne(int x, int y)
  {
    System.out.println(" x : " + Integer.toString(x)  + "  |  y : " + Integer.toString(y) + "  || Running Tally: " + Integer.toString(((x - y) + y)));
    if (x < y)
       return -3;
    else
       return fooOne(x - y, y + 3) + y;
  }

  public static int fooTwo(int x, int y)
  {
    System.out.println(" x : " + Integer.toString(x)  + "  |  y : " + Integer.toString(y) + "  || Running Tally: " + Integer.toString(((x +1) * x)));
    if (x > y)
       return -1;
    else if (x ==  y)
       return 1;
    else
       return x * fooTwo(x + 1, y);
  }


  public static void three()
	{
		System.out.println("Please enter a character : ");
		char c = in.next().charAt(0);
		System.out.println("Please enter a String : ");
		String tmpString = in.next();
     String r = "";
     for (int i = 0; i < tmpString.length(); i ++) {
        if (tmpString.charAt(i) != c)
          r += tmpString.charAt(i);
     }
		 System.out.println("Revised String -> " + r);
		 holdup();
  }

	public static int[] four()
	{
		int[] ans = new int[2];
		System.out.println("Enter n : ");
		int n = in.nextInt();
		System.out.println("Enter k : ");
		int k = in.nextInt();
		ans[0] = n;
		ans[1] = k;
		return ans;
	}

  public static int nCk(int n, int k)
	{
    if (k ==0 || n == 0 || k == n)
       return 1;
    else
       return nCk(n-1, k) + nCk(n-1, k-1);
  }
}
