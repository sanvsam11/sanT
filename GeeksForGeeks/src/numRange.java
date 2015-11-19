public class numRange
{
	public boolean isPresent(int x,int low,int high){
		if((x-low)<(high))return false;else return true;
	}
	public static void main(String ar[]){
		numRange ob=new numRange();
		System.out.println(ob.isPresent(10,10,100));
	}
}
