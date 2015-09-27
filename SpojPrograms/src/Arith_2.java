public class Arith_2
{
	public static void main(String ar[])
	{
		CQueueMaker question=new CQueueMaker();
		String exp="+*ab/cd";int i=0;
		while(i<exp.length()){
			question.push(exp.charAt(i));
		i++;}
		ExpressionTreeBuilder soltree=new ExpressionTreeBuilder(question);

	}

}
