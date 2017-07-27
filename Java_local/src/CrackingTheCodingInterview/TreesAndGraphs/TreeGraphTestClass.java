package CrackingTheCodingInterview.TreesAndGraphs;

import java.util.Random;

/**
 * Created by SanthoshVarathan on 09/07/17.
 */
public class TreeGraphTestClass {
    public static void main(String ar[]){
        Graph g = new GraphAdjacencySetImplementation<>(5, GraphAdjacencySetImplementation.GraphType.Directed);
        Random r = new Random();
        for(int i=0;i<10;i++){
            int source = r.nextInt(5),destination = r.nextInt(5);
            System.out.println(source+" "+destination);
            g.addEdge(source,destination);
        }
        g.printBreadthFirst();
    }
}
