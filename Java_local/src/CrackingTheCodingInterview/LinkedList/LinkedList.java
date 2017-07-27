package CrackingTheCodingInterview.LinkedList;

/**
 * Created by SanthoshVarathan on 06/07/17.
 */
public interface LinkedList<e> {
    public void printList();
    void insert(e data);
    void delete(e data);
    boolean contains(e data);
    node getHead();
    void setHead(node h);
    node getTail();
}
