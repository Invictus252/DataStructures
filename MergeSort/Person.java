public class Person implements Comparable<Person>
{
    private String m_first;
    private String m_last;
    private int m_age;

    Person(String first, String last, int age)
    {
        m_first = first;
        m_last = last;
        m_age = age;
    }

    @Override
    public int compareTo(Person other)
    {
  	  return m_last.compareTo(other.m_last);
    }

    @Override
    public String toString()
    {
        return m_last + ", " + m_first + " " + m_age;
    }
}
