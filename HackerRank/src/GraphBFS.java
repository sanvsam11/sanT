import java.util.*;
public class GraphBFS
{
	int v,e;
	public void getVerticesEdges(int v,int e){
		this.v=v;this.e=e;
	}
	public void CreateGraph(){
		
	}
	public static void main(String ar[]){
		Scanner in = new Scanner(System.in);
		int T= in.nextInt();
		GraphBFS ob[]=new GraphBFS[T];
		
			for(int i=0;i<T;i++){int v=in.nextInt(),e=in.nextInt();
			ob[i].getVerticesEdges(v,e);
			for(int j=0;j<e;j++){}
			ob[i].CreateGraph();}
	}
}
