import java.util.Scanner;
public class Arith_2
{
	String input;char op;
	int a,b,i=0,s=0;
	public void Parser(){char c;int l=input.length();
		while(i<l){c=input.charAt(i);
			if(c=='+'||c=='-'||c=='*'||c=='/')
			{op=c;
			a=Integer.parseInt(input.substring(0,i));
			b=Integer.parseInt(input.substring(i+1,input.length()));break;}
		i++;}
	}
	public void Evaluator(){i=0;
		switch(op){
			case '+':s=a+b;break;
			case '-':s=a-b;break;
			case '*':s=a*b;break;
			case '/':s=a/b;break;
		}
	}
	public void Product_Printer(){
		while(b>0){
			System.out.println(a*(b%10));
		b=b/10;}
	}
	public void Operation_Printer(String input){
		this.input=input;
		Parser();Evaluator();
		System.out.println(a);
		System.out.println(b);
		System.out.println(op+"------");
	    if(op=='*'){Product_Printer();
		System.out.println("------");}
		System.out.println(s);
		System.out.println(" ");
	}
	/*
	public static void main(String ar[])
	{
		int count;
		Scanner get_arith_input=new Scanner(System.in);
		count=get_arith_input.nextInt();
		Arith_2 ob=new Arith_2();
		while(count>0){
			ob.Operation_Printer(get_arith_input.next());
		count--;}
	}
	*/
}
