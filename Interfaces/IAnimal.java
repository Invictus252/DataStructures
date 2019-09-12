
import java.util.*;

public class IAnimal
{
	public static void main(String[] args)
	{
    // Create
    Pig p = new Pig("Porky");
    Duck d = new Duck("Daffy");
    // Run

    System.out.println(p.makeSound());
    System.out.println(d.makeSound());

	}



}
