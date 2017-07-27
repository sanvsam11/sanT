package Linked_List;

/**
 * Created by SanthoshVarathan on 29/04/17.
 */
public interface I_LinkedList<e> {
    public void insert(e element);
    public e delete();
    public void deleteKey(e key);
    public void deletePosition(int position);
    public int getLength();
    public boolean isPresent(e element);

}
