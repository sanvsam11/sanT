import java.util.HashMap;
import java.util.Map;

/**
 * Created by SanthoshVarathan on 12/03/17.
 */
public class Trie {
    TrieNode root;
    public Trie(char c){
        root=new TrieNode(c);
    }
    public void insert(String s){
        char[] stringArray = s.toCharArray();

    }
    public void insert(char c){

    }
}

class TrieNode{
    char element;
    Map<Character,TrieNode> children = new HashMap<>();
    public TrieNode(char c){
        element=c;
    }
    public boolean addChild(char c,TrieNode t){
        children.put(c,t);
    }
}