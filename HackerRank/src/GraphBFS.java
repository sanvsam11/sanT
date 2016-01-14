import java.util.*;
class vertex{
	int element;
	vertex next;
	public vertex(int element){this.element=element;next=null;}
}
public class GraphBFS
{
	int v,e;
	public void getVerticesEdges(int v,int e){
		this.v=v;this.e=e;
	}
	public void CreateGraph(int [][] edges){
		
	}
	public static void main(String ar[]){
		Scanner in = new Scanner(System.in);
		int T= in.nextInt();
		GraphBFS ob[]=new GraphBFS[T];
		
			for(int i=0;i<T;i++){int v=in.nextInt(),e=in.nextInt();
			ob[i].getVerticesEdges(v,e);
			int [][] edges=new int[v][2];
			for(int j=0;j<e;j++){edges[j][0]=in.nextInt();edges[j][1]=in.nextInt();}
			ob[i].CreateGraph(edges);
			}
	}
}
