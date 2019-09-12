public class Duck implements IAnimal
{
  private String m_name;

  public Duck(String name)
  {
      m_name = name;
  }


  public String makeSound(){
    String noise = m_name + " says quack quack quack!";
    return noise;
  }
}
