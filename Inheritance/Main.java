public class Main
{
	public static void main(String[] args)
	{
		IBinaryOperator s = new Sum(8, 12);
		IBinaryOperator d = new Diff(20, 8);
		System.out.println(s.operate());
		s.setOperand1(18);
		System.out.println(s.operate());
		System.out.println(d.operate());
		d.setOperand2(10);
		System.out.println(d.operate());
	}


}
