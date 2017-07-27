package Graph;

/**
 * Created by SanthoshVarathan on 28/05/17.
 */
class node<e>{
    e data;
    node nextEdge;
    node nextNode;
    e weight;
    public node(e d,node Node,node edge,e w){
        data=d;
        nextEdge=edge;
        nextNode=Node;
        weight = w;
    }
}
public class WeightedGraphList<e> {
     node head,c;
    public void addEdge(e data1,e data2,e weight){
        c = head;
        node n1=null,n2=null;
        if(c==null) {                                               //empty graph
            head = new node(data1,null,null,null);
            node newnode = new node(data2,null,null,null);
            head.nextNode=newnode;
            head.nextEdge=new node(data2,null,null,weight);
        }
        else{
            while(c.nextNode!=null&&c.data!=data2) c=c.nextNode;    // data2 is missing
                if(c.nextNode==null&&c.data!=data2){
                    n2 = new node(data2,null,null,null);
                    c.nextNode = n2;
                }
            c = head;
            while(c.nextNode!=null&&c.data!=data1) c=c.nextNode;    //data1 is missing
                if(c.nextNode==null&&c.data!=data1){
                    n1 = new node(data1,null,new node(data2,null,null,weight),null);
                    c.nextNode=n1;
                }
                else {
                    while(c.nextEdge!=null) c=c.nextEdge;           // adding edge when source node of new edge is present
                    c.nextEdge = new node(data2,null,null,weight);
                }
        }
    }
    public e removeEdge(e data1,e data2){
        c=head;
        while(c.data!=data1) c=c.nextNode;
        while(c.nextEdge.data!=data2) c=c.nextEdge;
        node t = c.nextEdge;
        c.nextEdge = t.nextEdge;
        return (e)t.weight;
    }
    public void printGraph(){
        node c = head,p=null;
        while(c!=null){
            System.out.print(c.data);
            p = c.nextEdge;
            while(p!=null) {
                System.out.print("-"+p.weight+"->"+p.data);
                p=p.nextEdge;
            }
            c=c.nextNode;
            System.out.println();
        }
    }

    public static void main(String ar[]){
        WeightedGraphList<Integer> g = new WeightedGraphList<>();
        g.addEdge(1,2,2);
        g.addEdge(1,3,3);
        g.addEdge(1,4,4);
        g.addEdge(2,3,6);
        g.addEdge(2,4,8);
        g.addEdge(2,1,2);
        g.addEdge(3,1,3);
        g.addEdge(3,4,12);
        g.addEdge(4,2,8);
        g.addEdge(4,4,16);
        g.printGraph();
    }

}
