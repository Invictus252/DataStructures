
import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
    // Create
    Main m = new Main();
		Schedule s = new Schedule();
		Course c1 = new Course("Networking I","8am","8:50am");
    Course c2 = new Course("Database","9am","9:50am");
    Course c3 = new Course("Web Development","10am","10:50am");
    Course c4 = new Course("Java I","12pm","12:50pm");
    Course c5 = new Course("Yoga","1pm","1:50pm");

    // Build
		s.addCourse(c1);
    s.addCourse(c2);
    s.addCourse(c3);
    s.addCourse(c4);
    s.addCourse(c5);

    // Run
    m.go(s);
	}
  private void go(Schedule x){
    System.out.println(x.toString());
  }

}
