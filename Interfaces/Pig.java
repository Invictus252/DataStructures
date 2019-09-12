public class Pig
{
  private String m_name;

  public Pig(String name)
  {
      m_name = name;
  }


  public String makeSound(){
    String noise = m_name + " says oink oink oink!";
    return noise;
  }
}
