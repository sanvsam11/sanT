package Graphs;

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
    
    public static void main(String ar[]){
        String elementString = "abcde",edgesString = "abacadaebabbbcbdbecacbcccdcedcdeeeeaeb";
        Graph g = new Graph();
        g.addElements(elementString);
        g.addEdges(edgesString);
        g.printGraph();
    }
    
}