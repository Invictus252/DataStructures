import java.util.*;

public class DataStruct
{
    public static List<String> m_choices;

    public DataStruct(int n)
    {
        m_choices = new ArrayList<String>();
        for (int i = 0; i < n; i++)
            m_choices.add("");
    }

    public DataStruct(ArrayList<String> l)
    {
        m_choices = new ArrayList<String>();
        m_choices.addAll(l);
    }

    public void print(){
      for ( String x : m_choices){
        System.out.print(x + " ");
      }
      System.out.println();
    }

    public int size(){
      int ctr=0;
      for ( String x : m_choices){
        ctr++;
      }
      return ctr;
    }

    public void remove(int x){
      m_choices.remove(x);
    }

    public String get(int x){
      return m_choices.get(x);
    }

    public List<String> toArray(){
      return m_choices;
    }

}
