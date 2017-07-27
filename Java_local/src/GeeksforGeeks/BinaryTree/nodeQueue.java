package GeeksforGeeks.BinaryTree;

/**
 * Created by SanthoshVarathan on 12/04/17.
 */
public class nodeQueue<e> {
    qNode head,cur;
    public nodeQueue(node tn){
        head = new qNode(tn);
    }
    public void enqueue(node tn){
        qNode<e> newnode = new qNode<>(tn);
        if(head==null) head = newnode;
        else {
            cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = newnode;
        }
    }
    public node<e> dequeue(){
        if(head==null) return null;
        else {
            qNode temp = head; head = head.next;
            return temp.treeNode;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
}
class qNode<e>{
    node<e> treeNode;
    qNode<e> next;
    qNode(node n){
        treeNode = n;next=null;
    }
    public void setNext(node n){
        qNode<e> nextNode = new qNode<>(n);
        next = nextNode;
    }
}