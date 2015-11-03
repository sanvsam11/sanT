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
    int  valuesinput[],solution=0;
    public char ExpressionTreeEvaluator(tnode c){char ach,bch;int a=0,b=0;
        ach=ExpressionTreeEvaluator(c.left);bch=ExpressionTreeEvaluator(c.right);

//<<<<<<< HEAD
        if(c!=null){
            switch (c.element){
                case '+':solution=a+b;break;
                case '-':solution=a-b;break;
                case '*':solution=a*b;break;
                case '/':solution=a/b;break;
                default:
            }
        }
    return c.element;}
//=======
    public int ExpressionTreeEvaluator(int [] input){int answer=0;
       
    return answer;}
//>>>>>>> 147c11108b8769f803bc25d93056a91f3897f0ea
}
