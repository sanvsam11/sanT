package Graphs;
import Stack.Stack;
import queue.queue;
/**
 * Created by SanthoshVarathan on 04/09/16.
 */

public class Graph {
    Adjacency_List a;
    public Graph(){
        a=new Adjacency_List();
    }
    public void addElements(String elementString){
        for(int i=0;i<elementString.length();i++){
            a.addListNode(elementString.charAt(i));
        }
    }
    public void addEdges(String edgesString){
        for(int i=0;(i+1)<edgesString.length();i+=2){
            a.addLink(edgesString.charAt(i),edgesString.charAt(i+1));
        }
    }
    public void printGraph(){
        a.printList();
    }

    public void printPath(char s,char d){
        Stack<Character> path = new Stack<Character>(s);

    }
    public void bfs(){Adjacency_List_Node c = a.head;c.state=1;queue<Adjacency_List_Node> q=new queue<Adjacency_List_Node>(c);
            while (!q.isEmpty()) {
                c = q.dequeue();if(c.state==2)break;
                Linker_Node l = c.link;
                System.out.println(c.element);
                while (l != null) {
                    q.enqueue(l.v);l.v.state=1;
                    l = l.next;
                }
                c.state = 2;
            }
    }
//<<<<<<< HEAD
//=======
	public void breadthFirstSearch(){}

//>>>>>>> f2822634eb6869959c0e95e0f9a407f5f221be7a
    public static void main(String ar[]){
        //String elementString = "abcde",edgesString = "abacadaebabbbcbdbecacbcccdcedcdeeeeaeb";
        String elementString = "rstuvwxy",edgesString = "rsrvsrswwtwxwstwtutxxwxuxtxyutuxuyyxyu";
        Graph g = new Graph();
        g.addElements(elementString);
        g.addEdges(edgesString);
        //g.printGraph();
        g.bfs();
    }
    
}
