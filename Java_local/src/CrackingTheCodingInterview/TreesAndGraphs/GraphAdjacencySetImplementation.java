package CrackingTheCodingInterview.TreesAndGraphs;

import java.util.*;

/**
 * Created by SanthoshVarathan on 09/07/17.
 */
class graphNode{
    int id;
    Set<graphNode> AdjacentNodes = new HashSet<>();
    public graphNode(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public Set<graphNode> getAdjacentSet(){
        return AdjacentNodes;
    }
    public void addEdge(graphNode e){
        AdjacentNodes.add(e);
    }
    public void removeEdge(graphNode e){
        AdjacentNodes.remove(e);
    }
    public boolean hasEdge(graphNode e){
        return AdjacentNodes.contains(e);
    }
}
public class GraphAdjacencySetImplementation<t> implements Graph{
    List<graphNode> nodes = new ArrayList<>();
    Queue<graphNode> breadthfirstQueue = new ArrayDeque<>();
    enum GraphType {Directed,Undirected};
    GraphType graphType;
    public GraphAdjacencySetImplementation(int n,GraphType gt){
        graphType = gt;
        for(int i=0;i<n;i++)
            nodes.add(new graphNode(i));
    }
    public boolean checkId(int i){
        return i<nodes.size()&&i>=0;
    }
    public void addEdge(int i,int j){
        if(!checkId(i)||!checkId(j))
            return;
        nodes.get(i).addEdge(nodes.get(j));
        if(graphType==GraphType.Undirected)
            nodes.get(j).addEdge(nodes.get(i));
    }
    public void removeEdge(int i,int j){
        if(!checkId(i)||!checkId(j))
            return;
        nodes.get(i).removeEdge(nodes.get(j));
        if(graphType==GraphType.Undirected)
            nodes.get(j).removeEdge(nodes.get(i));
    }
    public boolean checkEdge(int source,int destination){
        return nodes.get(source).hasEdge(nodes.get(destination));
    }
    public void printAdjacencyList(){
        for(graphNode n:nodes){
            System.out.print(n.getId());
            for(graphNode nn:n.getAdjacentSet())
                System.out.print("->"+nn.getId());
            System.out.println();
        }
    }
    public void printBreadthFirst(){
        boolean visitedArray[] = new boolean[nodes.size()];
        breadthfirstQueue.clear();
        breadthfirstQueue.add(nodes.get(0));
            while(!breadthfirstQueue.isEmpty()){
                graphNode N = breadthfirstQueue.remove();
                visitedArray[N.getId()] = true;
                System.out.print(N.getId()+" ");
                for(graphNode adjacentN:N.getAdjacentSet())
                    if(!visitedArray[adjacentN.getId()])
                        breadthfirstQueue.add(adjacentN);
            }
    }
}
