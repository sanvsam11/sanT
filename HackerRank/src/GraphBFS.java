import java.util.*;
class vertex{
	int element;
	vertex next;
	public vertex(int element){this.element=element;next=null;}
	public vertex(){
		next = null;
	}
}
class aListVertex extends vertex{
	int degree=0;
	public int degreeOfVertex(){return degree;}
}
class evertex extends vertex{
	public evertex(int element){this.element = element;next = null;}
}
public class GraphBFS
{
	int v,e;
	aListVertex[] adjacencyList;
	public GraphBFS(int v,int e){
		this.v=v;this.e=e; adjacencyList = new aListVertex[v];

	}
	public void CreateGraph(int [][] edges){vertex temp;
		for(int i=0;i<e;i++){temp=adjacencyList[edges[i][0]-1];
			if(adjacencyList[edges[i][0]-1].next==null)adjacencyList[edges[i][0]-1].next = new evertex(edges[i][1]);
		else {while(temp.next!=null)temp=temp.next;temp = new evertex(edges[i][1]);}
			adjacencyList[edges[i][0]-1].degree++;}
	}
	public void printGraph(){vertex temp;
		for(int i=0;i<v;i++){temp = adjacencyList[i];
			System.out.println(adjacencyList[i].element);
			while(temp.next!=null){System.out.print("->" + temp.element);}
		}
	}
	public static void main(String ar[]){
		Scanner in = new Scanner(System.in);
		int T= in.nextInt();
		GraphBFS ob[]=new GraphBFS[T];
			for(int i=0;i<T;i++){int v=in.nextInt(),e=in.nextInt();
			ob[i]=new GraphBFS(v,e);
			int [][] edges=new int[v][2];
			for(int j=0;j<e;j++){edges[j][0]=in.nextInt();edges[j][1]=in.nextInt();}
			ob[i].CreateGraph(edges);
			}
	}
}
