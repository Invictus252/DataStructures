public class Sum implements IBinaryOperator
{
  private int op1;
  private int op2;

  public Sum (int x,int y){
    op1 = x;
    op2 = y;
  }
  public void setOperand1(int x){
    op1 = x;
  }
  public void setOperand2(int y){
    op2 = y;
  }
  public int getOperand1(){
    return op1;
  }
  public int getOperand2(){
    return op2;
  }
  public int operate(){
    return op1 + op2;
  }

}
