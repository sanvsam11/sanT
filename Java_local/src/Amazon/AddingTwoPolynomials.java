package Amazon;

import java.util.LinkedList;

/**
 * Created by SanthoshVarathan on 20/07/17.
 */
class term{
    int constant,exponent;
    public term(int c,int e){
        constant = c;
        exponent = e;
    }
    public static void addTerm(int c,int e,LinkedList<term> list){
        term t = new term(c,e);
        list.add(t);
    }
}
public class AddingTwoPolynomials {
    public LinkedList<term> polynomialAdder(LinkedList<term> list1, LinkedList<term> list2){
        LinkedList<term> result = new LinkedList<>();
        int diff = list1.size() - list2.size();
        boolean isFirst = diff>0?true:false;
        diff = Math.abs(diff);
        while(list1.getFirst().exponent!=list2.getFirst().exponent&&diff>0){
            if(isFirst)
                result.add(list1.removeFirst());
            else
                result.add(list2.removeFirst());
            diff--;
        }
        while(!list1.isEmpty()&&!list2.isEmpty()){
            int exp = list1.getFirst().exponent;
            result.add(new term(list1.removeFirst().constant+list2.removeFirst().constant,exp));
        }
        return result;
    }
    public static void main(String ar[]){
        LinkedList<term> l1 = new LinkedList<>();
        LinkedList<term> l2 = new LinkedList<>();
        term.addTerm(5,2,l1);
        term.addTerm(4,1,l1);
        term.addTerm(2,0,l1);
        term.addTerm(5,1,l2);
        term.addTerm(5,0,l2);
        for(term t:new AddingTwoPolynomials().polynomialAdder(l1,l2))
            System.out.print(t.constant+"^"+t.exponent+"+");
    }
}
