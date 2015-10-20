/**
 * Created by sant on 11/10/15.
 */
public class IntStackMaker {
    int []stackarray;
    public IntStackMaker(int stacksize){
		stackarray=new int[stacksize];
	}
	public static void main(String  ar[]){
		IntStackMaker ob=new IntStackMaker(5);
		ob.stackarray[0]=1;
		ob.stackarray[1]=2;
	}
}
