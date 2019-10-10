import java.util.*;

public class Main
{
    public static void main(String args[])
    {
      // -----------------------------------
      // do not edit main...
      // -----------------------------------
      List<Person> people = new ArrayList<Person>();

      people.add(new Person("Frank", "Denton", 73));
      people.add(new Person("Mark", "Cohen", 44));
      people.add(new Person("Tim", "Smith", 22));
      people.add(new Person("Steve", "Denton", 16));
      people.add(new Person("Andy", "Ashton", 44));
      people.add(new Person("Albert", "Denton", 58));

      System.out.println("people ->" + people);
      Collections.sort(people);
  		System.out.println("people srtd ->" + people);
      List ans = mergeSort(people);
      System.out.println("ans ->" + ans);
      // -----------------------------------
    }

    public static List mergeSort(List items)
    {
        List sorted = new ArrayList();
        if (items.size() == 1) // base case...
        {
            // -----------------------------------
            return items;

            // -----------------------------------
        }
        else // recursive call...
        {
            // -----------------------------------
            List left = items.subList(0, items.size()/2);
            List right = items.subList(items.size()/2, items.size());
            System.out.println("left ->" + left);
            System.out.println("right ->" + right);
            left = mergeSort(left);
            right = mergeSort(right);
            sorted = merge(left,right);

            // -----------------------------------
        }
        return sorted;
    }
    //
    private static List merge(List partA, List partB)
    {
         List merged = new ArrayList();
         System.out.println("partA ->" + partA);
         System.out.println("partB ->" + partB);
         // -----------------------------------
         // while(partA.size() != 0 && partB.size() != 0){
         //   if(partA.get(0).compareTo(partB.get(0)) != 0){
         //     merged.add(partB.get(0));
         //     partB.remove(0);
         //   }
         //   else{
         //     merged.add(partA.get(0));
         //     partA.remove(0);
         //   }
         // }
         // while(partA.size() != 0){
         //   merged.add(partA.get(0));
         //   partA.remove(0);
         // }
         //
         // while(partB.size() != 0){
         //   merged.add(partB.get(0));
         //   partB.remove(0);
         // }
         // -----------------------------------

         return merged;
    }
}
