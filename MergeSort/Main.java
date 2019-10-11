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

      List<Person> ans = mergeSort(people);
      System.out.println(ans);
      // -----------------------------------
    }

    public static List<Person> mergeSort(List<Person> items)
    {
        List<Person> sorted = new ArrayList<Person>();
        List<Person> left = new ArrayList<Person>();
        List<Person> right = new ArrayList<Person>();
        if (items.size() == 1) // base case...
        {
            // -----------------------------------
            return items;

            // -----------------------------------
        }
        else // recursive call...
        {
            // -----------------------------------
            for(int i = 0;i <= items.size()/2;i++){
              left.add(items.get(i));
              items.remove(i);
            }
            for(int j = 0 ;j <= items.size()-1 ;j++){
              right.add(items.get(j));
            }
            left = mergeSort(left);
            right = mergeSort(right);
            sorted = merge(left,right);

            // -----------------------------------
        }
        return sorted;
    }
    //
    private static List<Person> merge(List<Person> partA, List<Person> partB)
    {
         List<Person> merged = new ArrayList<Person>();
         // -----------------------------------

         while(partA.size() != 0 && partB.size() != 0){
           merged.add(partA.get(0));
           merged.add(partB.get(0));
           partA.remove(0);
           partB.remove(0);
           Collections.sort(merged);
         }
         while(partA.size() != 0){
           merged.add(partA.get(0));
           partA.remove(0);
           Collections.sort(merged);
         }

         while(partB.size() != 0){
           merged.add(partB.get(0));
           partB.remove(0);
           Collections.sort(merged);
         }
         // -----------------------------------

         return merged;
        }
}
