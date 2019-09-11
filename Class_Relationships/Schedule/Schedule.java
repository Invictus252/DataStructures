import java.util.*;

public class Schedule
{
  private List<Course> schedule = new ArrayList<Course>();
  private static int c_count = 0;

  public Schedule(){}

  public void addCourse(Course c)
  {
    schedule.add(c_count,c);
    c_count++;
  }

  @Override
  public String toString()
  {
    String border = "|||||||||||||||||||||||||||||||||||||||||||||||||||||||\n";
    String out = border;
    out += String.format("|%-53.19s|\n", "Your Schedule");
    out += border;
    out += String.format("|%-3s%21s%19s%8s\n","Course","Start","End","|");
    out += border;
    for(Course x : schedule)
      out += String.format("|%-20s %5s %20s      |\n",x.getTitle(),x.getStart(),x.getEnd());
    out += border + "\n\nYour Schedule\n";
    for(Course x : schedule)
      out += x.toString() + "\n";
    return out;
  }
}
