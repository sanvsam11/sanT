public class Arith
{
	public static class Formula{
		String inp;
		char or1,or2,op;int l,s;
		public Formula(String inp){this.inp=inp;}
		public void parser(){l=inp.length();
			for(int i=0;i<l;i++){
				if(inp.charAt(i)=='+'||inp.charAt(i)=='-'||inp.charAt(i)=='*'||inp.charAt(i)=='/'){
				or1=inp.charAt(i-1);op=inp.charAt(i);or1=inp.charAt(i+1); break;	
				}
			}
		}
		public void Compute(){
			switch(op){
				case '+':s=or1+or2;break;
				case '-':s=or1-or2;break;
				case '*':s=or1*or2;break;
				case '/':s=or1/or2;break;
			}System.out.println("Solution:"+s);
		}
	}
	public static void main (String ar[]){
		
		String inp=new String();
		inp="24+26";
		Formula qn=new Formula(inp);
		qn.parser();
		qn.Compute();
		
	}
}
