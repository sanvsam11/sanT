package Graph;

/**
 * Created by SanthoshVarathan on 28/05/17.
 */
public interface graph<e> {
    public void addEdge(e data1,e data2,e weight);
    public e removeEdge(e data1,e data2);           // returns the weight of the deleted edge
    public void printGraph();
}
