/**
 * Created by sant on 27/9/15.
 */
public class ExpressionTreeBuilder {
    CQueueMaker input=new CQueueMaker();

    tnode Root;
    public ExpressionTreeBuilder(CQueueMaker input){
        this.input=input;
    }

    public tnode TreeBuilder(tnode c){if(!input.IsEmpty()) {
        char ch = input.pop();
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            if (Root == null) {
                Root = new tnode(ch);
                c = Root;
            } else {
                c = new tnode(ch);
            }
            c.left = TreeBuilder(c.left);
            c.right = TreeBuilder(c.right);
        } else {
            c = new tnode(ch);
        }
    }
    return c;}

    public int ExpressionTreeEvaluator(int [] input){int answer=0;
       
    return answer;}
}
