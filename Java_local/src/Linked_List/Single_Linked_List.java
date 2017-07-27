package Linked_List;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SanthoshVarathan on 29/04/17.
 */
public class Single_Linked_List<e extends Comparable<e>> implements I_LinkedList<e>{
   node head,left;
    public Single_Linked_List(e element){
        head = new node(element);
    }
    public Single_Linked_List(){
        head = null;
    }
    public void insert(e element){
        if(head==null) {head = new node(element);return;}
        node n=head;
        while(n.next!=null) n=n.next;
        node<e> newnode = new node<e>(element);
        n.next = newnode;
    }
    public void insert(node nd){
        node n = head;
        while(n.next!=null) n=n.next;
        n.next = nd;
        n=n.next;
    }
    public void insertMultiple(e...element){
        for(e data:element){
            insert(data);
        }
    }
    public void insertSorted(e element){
        node p = null,n=head,newnode = new node(element);
        if(n==null) {head = newnode;return;}
        else
        while(n!=null) {
            if ((Integer) n.data > (Integer) element) {
                if (p == null) head = newnode;
                else p.next = newnode;
                newnode.next = n;return;
            }
            else{
                p=n;n=n.next;
            }
        }
        if(n==null) p.next = newnode;
    }
    public e delete(){
        e element = (e)head.data;
        head = head.next;
        return element;
    }
    public void deleteKey(e element){
        node n = head,p=null;
        while(n!=null){
            if(n.data==element) break;
            p=n;n=n.next;
        }
        if(n==null) System.out.println("Failed to delete node "+element);
        else {
            node nextNode = n.next;
            if(p==null) head.next = nextNode;
            else p.next = nextNode;
            n=null;
        }
    }
    public void deletePosition(int position){
        node n = head,p=null;
        for(int i=1;i!=position;i++) {p = n;n = n.next;}
        if(p==null) head = head.next;
        else{
            p.next = n.next; n=null;
        }
    }
    public int lengthIterative(){
        node n = head;int length=0;
        while(n!=null) {
            length++;n=n.next;
        }
        return length;
    }
    public int lengthRecursive(node n){
        if(n==null) return 0;
        else return lengthRecursive(n.next)+1;
    }
    public int getLength(){
        //if(lengthIterative()==lengthRecursive(head))
        return lengthRecursive(head);
    }
    public boolean isPresentIterative(e element){
        node n = head;
        while(n!=null){
            if(n.data==element) return true;
            n=n.next;
        }
        return false;
    }
    public boolean isPresentRecursive(node n, e element){
        if(n==null) return false;
        else if(n.data==element) return true;
        else return isPresentRecursive(n.next,element);
    }
    public boolean isPresent(e element){
        return isPresentRecursive(head,element)&&isPresentIterative(element);
    }
    public void swapNodes(e element1, e element2) {
       node n = head,p1 = null,p2=null,n1=null,n2=null,s1=null,s2=null;
        if(n.data==element1||n.data==element2){s1=n;n1=s1.next;}
        while(n.next!=null){
            if(n.next.data==element1||n.next.data==element2)
                if(s1==null)
                    {p1=n;s1=p1.next;n1=n.next.next;n=n.next;}
                else
                    {p2=n;s2=p2.next;n2 = n.next.next;break;}
            else n=n.next;
        }
        //s1=p1.next;s2=p2.next;
        if(p1==null){
            head=s2;head.next = n1;
            p2.next = s1;
            s1.next = n2;
        }
        else {
            p1.next = s2;
            p2.next = s1;
            s1.next = n2;
            s2.next = n1;
        }
    }
    public void swapNodes2(e element1, e element2){
        node p1=null,c1=null,p2=null,c2=null,n=head;
        if(n.data==element1||n.data==element2) c1=n;
        while(n.next!=null) {
            if (n.next.data == element1 || n.next.data == element2) {
                if (c1 == null) {
                    p1 = n;
                    c1 = p1.next;
                    n = n.next;
                } else {
                    p2 = n;
                    c2 = p2.next;
                    break;
                }
            }
                n = n.next;
        }
        if(p1==null)
            head = c2;
        else
            p1.next = c2;
        if(p2==null)
            head = c1;
        else
            p2.next = c1;

        node temp = c1.next;
        c1.next = c2.next;
        c2.next = c1;
    }                               //to be debugged.
    public e middleReturn(){
        node fast=head,slow=head;
        while(fast!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return (e)slow.data;
    }
    public e nthNodeFromLeft(int n){
        node endHit=head,targetHit=head;
        for(int i=0;i<n;i++){
            endHit=endHit.next;
        }
        while(endHit!=null){
            endHit=endHit.next;targetHit=targetHit.next;
        }
        return (e)targetHit.data;
    }
    public int countKey(e element){
        node n = head;int count=0;
        while(n!=null){if(n.data==element) count++;n=n.next;}
        return count;
    }
    public node reverseList(node p,node n){
        if(n.next==null) {
            n.next=p;
        }
        else{
            node newnode = n.next;
            n.next = p;p=n;
            n=reverseList(p,newnode);
        }
        return n;
    }
    public void printList(){
        node n = head.next;
        System.out.print(head.data);
        while(n!=null) {System.out.print("->"+n.data);n=n.next;}
        System.out.println();
    }
    public node hasLoop(){
        node fast=head,slow=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return slow;
        }
        return null;
    }
    public node mergeSortedLists(node<e> node1, node<e> node2){
        node resultHead =null,cn=resultHead;

        while(node1!=null&&node2!=null){
            if((Integer)node1.data<(Integer)node2.data) {
                if(cn==null) {cn=node1;resultHead=cn;}
                else {cn.next = node1;cn=cn.next;}
                node1=node1.next;
            }
            else if((Integer)node1.data>(Integer)node2.data){
                if(cn==null) {cn=node2;resultHead=cn;}
                else {cn.next = node2;cn=cn.next;}
                node2 = node2.next;
            }
            else if((Integer)node1.data==(Integer)node2.data){
                if(cn==null) {cn=node1;resultHead=cn;}
                else {cn.next = node1;cn=cn.next;}
                node1=node1.next;
                cn.next = node2;cn=cn.next;
                node2=node2.next;
            }
        }
        if(node1==null) cn.next=node2;
        else if(node2==null) cn.next = node1;
        return resultHead;
    }
    public boolean isPalindrome(node right){
        left=head;
        if(right==null) return true;
        boolean rightIsPalindrome = isPalindrome(right.next),result=false;
        if(!rightIsPalindrome) return false;
        else if(left.data==right.data) {
            result=true;
            left = left.next;
        }
        return result;
    }
    public void deleteRepeatsSorted(){
        node n=head.next,p=head;
        e element=(e)head.data;
        while(n!=null){
            if(n.data==element)p.next = n.next;
            else {p=n;element = (e)n.data;}
            n=n.next;

        }
    }
    public void deleteRepeatsUnsorted(){
        Set<e> elements = new HashSet<>();
        node n = head,p=null;
        while(n!=null){
            if(!elements.contains(n.data))
            {
                elements.add((e)n.data);
                p=n;n=n.next;
            }
            else
            {
                n=n.next;p.next=n;
            }
        }
    }
    public void pairSwap(){
        head = pairSwap(head,head.next);
    }
    public node pairSwap(node p,node n) {
        if (n.next == null) {
            p.next=null;
            n.next=p;
        }
        else if(n==null) return p;
        else
        {
         node temp = n.next;
         n.next = p;p.next = temp;
         p.next = pairSwap(p.next, p.next.next);
        }
        return n;
    }
    public node mergeSortMethod(node left,node right){
        Single_Linked_List result = new Single_Linked_List();
        if(left.next==null) return left;
        else if(right.next==null) return right;
        else{
            node leftM=splitList(left),rightM = splitList(right);
            left = mergeSortMethod(left,leftM);
            right = mergeSortMethod(right,rightM);
            while(left!=null){
                result.insertSorted((e)left.data);
                left = left.next;
            }
            while(right!=null){
                result.insertSorted((e)right.data);
                right = right.next;
            }
        }
        return result.head;
    }
    public void mergeSort(){
        node m=head,e=head;
        while(e!=null) {
            if (e.next == null) break;
            m = m.next;
            e = e.next.next;
        }
            printList(mergeSortMethod(head,m));

    }                                                   //to be debugged.
    public node splitList(node h){
        node m=h,e=h;
        while(e!=null){
            if(e.next==null)break;
            m=m.next;e=e.next.next;
        }
        return m;
    }
    public void lastToFirst(){
        if(head==null) return;
        else{
            node end = head;
            while(end.next.next!=null) end = end.next;
            end.next.next = head;
            head = end.next;
            end.next = null;
        }
    }
    public void deleteAlternateNodes(){
        node n = head;
        while(n.next.next!=null){
            n.next = n.next.next;
            n=n.next;
        }
    }
    public node splitAlternateNodes(){
        if(head==null) return null;
        if(head.next==null) return null;
        node n1 = head,n2 = head.next,list2 = head.next;
        while(n2!=null){
            if(n2.next==null) break;
            n1.next = n2.next;
            n1 = n1.next;
            n2.next = n1.next;
            n2 = n2.next;
        }
        if(n1.next!=null) n1.next = null;
        return list2;
    }
    public void deleteLesserNode(){
        node n = head.next,p=head;
        while((Integer)p.data<(Integer)n.data) {

            if(n==null) return;
            head = n;
            p = n;
            if(n.next == null) return;
            n=n.next;
        }
        while(n!=null){
            if((Integer)n.data<(Integer)n.next.data) p.next = n.next;
                p=p.next;
                n=p.next;
        }
    }
    public node reversekNodes(int k,node curr){
        if(curr==null) return null;
        node prev=null,next=null;
        int count=k;
        while(count-->0&&curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;curr=next;
        }
        if(curr!=null)
            curr.next = reversekNodes(k,curr.next);
        return prev;
    }                               //to be debugged.
    public node splitEvenOdd(node head){
        node o = head, e_head = head.next,e=e_head;
        while(e!=null&&o!=null){
            if(e.next==null) {o.next = null;break;}
            o.next = e.next;
            e.next = e.next.next;
            o = o.next;
            e = e.next;
        }
        return e_head;
    }
    public void removeLoop(){
        node slowPointer=head;
        node loopNode = hasLoop();
        if(loopNode==null) return;
        /*                                                     // method 1: hashing nodes to detect duplicate
        Set<node> list = new HashSet<>();
        slowPointer = head;
        while(!list.contains(slowPointer.next)){
            list.add(slowPointer);
            slowPointer=slowPointer.next;
        }
        slowPointer.next=null;
        */                                                      //method 2: finding length of loop and incrementing two pointers from head and loop until coincidence
        node loopCounter = loopNode.next,p_head = head;
        int loopCount=1;
        while(loopCounter!=loopNode){
            loopCounter=loopCounter.next;
            loopCount++;
        }
        loopCounter=head;
        while(loopCount-->0) loopCounter=loopCounter.next;
        while(p_head.next!=loopCounter.next){
            p_head=p_head.next;
            loopCounter=loopCounter.next;
        }
        loopCounter.next=null;
    }
    public int add1(node n){
        int c = 0;
        if(n.next!=null) c = add1(n.next);
        if(n.next==null&&(int)n.data==9){n.data=0;return 1;}
        if(c+(int)n.data>9) {n.data = (c + (int) n.data) % 10;return 1;}
        else n.data = c + (int)n.data;
        return 0;
    }
    public void printList(node n){
        System.out.print(n.data);n=n.next;
        while(n!=null) {System.out.print("->"+n.data);n=n.next;}
    }
}
