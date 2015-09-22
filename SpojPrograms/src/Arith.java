public class Arith
{
	public static class Formula{
		String inp;
		String or1,or2;char op;int l,s,a,b;
		public Formula(String inp){this.inp=inp;}
		public void parser(){l=inp.length();
			for(int i=0;i<l;i++){
				if(inp.charAt(i)=='+'||inp.charAt(i)=='-'||inp.charAt(i)=='*'||inp.charAt(i)=='/'){
				or1=inp.substring(0,i);op=inp.charAt(i);or2=inp.substring(i+1,l); break;	
				}
			}a=Integer.parseInt(or1);b=Integer.parseInt(or2);
		}
		public void Compute(){
			switch(op){
				case '+':s=a+b;break;
				case '-':s=a-b;break;
				case '*':s=a*b;break;
				case '/':s=a/b;break;
			}System.out.println("Solution:"+s);
		}
	
	public void Display(){
		System.out.println(or1+op+or2+"="+s);
		System.out.println(a+" "+op+" "+b+"="+s);
	}}
	public static void main (String ar[]){
		
		String inp=new String();
		inp="400*4";
		Formula qn=new Formula(inp);
		qn.parser();
		
		qn.Compute();
		//qn.Display();
		
	}
}
