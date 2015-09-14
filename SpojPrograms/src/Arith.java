public class Arith
{
	public static class Formula{
		char or1,or2,op;int l;
		
		public void parser(String inp){l=inp.length();
			for(int i=0;i<l;i++){
				switch(inp.charAt(i)){
					case '+':or1=inp.charAt(i-1);op=inp.charAt(i);or1=inp.charAt(i+1); break;
					case 
				}
			}
		}
	}
	public static void main (String ar[]){
		
		String inp=new String();
		inp="24+26";
		
		
	}
}
