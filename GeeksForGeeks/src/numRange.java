public class numRange
{
	public boolean isPresent(int x,int low,int high){
		if(((x-low)*(high-x))<0)return false;else return true;
	}
	public static void main(String ar[]){
		numRange ob=new numRange();
		System.out.println(ob.isPresent(9,10,100));
	}
}
