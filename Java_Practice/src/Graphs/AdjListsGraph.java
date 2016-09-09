package Graphs;

/**
 * Created by SanthoshVarathan on 05/09/16.
 */
//public class AdjListsGraph {
//}
import java.util.Iterator;
        import java.util.LinkedList;

/**
 * This class implements an element of an adjacency linked-list in the adjacency
 * lists graph representation.
 */
class AdjListElmnt {
    /**
     * The target node.
     */
    public int target;

    /**
     * The weight of the corresponding edge (i.e., the edge from the node whose
     * adjacency list this AdjListElmnt belongs to, to the target node).
     */
    public double weight;

    /**
     * Class constructor.
     */
    public AdjListElmnt(int target, double weight) {
        this.target = target;
        this.weight = weight;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "(" + target + "; " + (float) weight + ")";
    }
}

/**
 * This is a graph implementation that uses adjacency lists to store edges. It
 * contains one linked-list for every node i of the graph. The list for i
 * contains one instance of AdjListElmnt for every node that is adjacent to i.
 * For directed graphs, if there is an edge from node i to node j then there is
 * a corresponding element in the adjacency lists of node i (only). For
 * undirected graphs, if there is an edge between nodes i and j, then there is a
 * corresponding element in the adjacency lists of *both* nodes i and j. The
 * lists are not sorted; they contain the adjacent nodes in *reverse order* of
 * edge insertion. In other words, for a directed graph, the node at the head of
 * the list of some node i corresponds to the edge *with source* i that was
 * added to the graph most recently (and has not been removed, yet). For an
 * undirected graph, the node at the head of the list of some node i corresponds
 * to the edge *with source or target* i that was added to the graph most
 * recently (and has not been removed, yet).
 */

public class AdjListsGraph extends Graph {

    /**
     * The array of adjacency lists.
     */
    private LinkedList<AdjListElmnt>[] lists;

    /**
     * It initializes the number of nodes and the directed variable instances,
     * and instantiates the array of adjacency lists so that each list is empty.
     *
     * @param nodes
     *            the number of nodes.
     * @param directed
     *            true of the graph is directed.
     */
    @SuppressWarnings("unchecked")
    public AdjListsGraph(int nodes, boolean directed) {
        super(nodes, directed);

        lists = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++)
            lists[i] = new LinkedList<AdjListElmnt>();
    }

    /*
     * (non-Javadoc)
     *
     * @see Graph#addEdge(int, int, double)
     *
     * The new edge is added at the *front* of the adjacency list of the source
     * node. If the Graph is undirected, it is also added at the *front* of the
     * adjacency list of the target node.
     *
     */
    public void addEdge(int source, int target, double weight) {
        // TODO: Fill in the body of this method.

    }

    /*
     * (non-Javadoc)
     *
     * @see Graph#addEdgeSafe(int, int, double)
     *
     * The new edge is added at the *front* of the adjacency list for source
     * node. If the Graph is undirected, it is also added at the *front* of the
     * adjacency list for target node.
     */
    public boolean addEdgeSafe(int source, int target, double weight) {
        // TODO: Fill in the body of this method.

        // TODO: remove next line --- added so that starter code compiles
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see Graph#removeEdge(int, int)
     */
    public double removeEdge(int source, int target) {
        // TODO: Fill in the body of this method.

        // TODO: remove next line --- added so that starter code compiles
        return 1. / 0.;
    }

    /*
     * (non-Javadoc)
     *
     * @see Graph#removeAllEdges()
     */
    public void removeAllEdges() {
        for (int i = 0; i < nNodes; i++)
            lists[i].clear();
    }

    /*
     * (non-Javadoc)
     *
     * @see Graph#weightOfEdge(int, int)
     */
    public double weightOfEdge(int source, int target) {
        // TODO: Fill in the body of this method.

        // TODO: remove next line --- added so that starter code compiles
        return 1. / 0.;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < nNodes; i++) {
            s += i + "->";

            for (Iterator<AdjListElmnt> iter = lists[i].iterator(); iter
                    .hasNext();)
                s += " " + iter.next();
            s += "\n";
        }

        return s;
    }

    /*
     * (non-Javadoc)
     *
     * @see Graph#toAltGraphRepr(Graph)
     */
    public Graph toAltGraphRepr(Graph g) {
        // TODO: Fill in the body of this method.

        return g;
    }

    /**
     * This method returns the adjacency linked-list of node i.
     *
     * @param i
     *            node
     * @return the adjacency linked-list of i
     */
    public LinkedList<AdjListElmnt> getAdjListOfNode(int i) {
        return lists[i];
    }

}