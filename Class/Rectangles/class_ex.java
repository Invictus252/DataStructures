import java.util.*;

public class class_ex
{
	private Rectangle r1;
	private Rectangle r2;

	public static void main(String[] args)
	{
		class_ex m = new class_ex();
		m.go();
	}

	private void go()
	{
		r1 = new Rectangle(2,3);
		r2 = new Rectangle(4,5);

		System.out.println(r1.toString());
		System.out.println(r2.toString());
		System.out.println(Rectangle.getCount());
		System.out.println(r1.getWidth());
		System.out.println(r2.getWidth());
	}
}
