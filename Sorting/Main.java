import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
	  Main main = new Main();
	  main.go();
	}

	private void go()
	{
		Person p1 = new Person("a", 1);
		Person p2 = new Person("b", 2);
		Person p3 = new Person("c", 3);
		Person p4 = new Person("d", 4);
    Person p5 = new Person("e", 5);
		Person p6 = new Person("f", 6);
		Person p7 = new Person("g", 7);
		Person p8 = new Person("h", 8);

		List<Person> people = new ArrayList<Person>();
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
    people.add(p5);
		people.add(p6);
		people.add(p7);
		people.add(p8);

		System.out.println(people);

		Collections.sort(people);
		System.out.println(people);
    Collections.sort(people,

		  (Person x, Person y) ->
		  {
		    if (x.getAge() > y.getAge())
		      return 1;
		    else if (x.getAge() < y.getAge())
		      return -1;
		    else
		      return 0;
		  }

		);
		System.out.println(people);
  }
}
