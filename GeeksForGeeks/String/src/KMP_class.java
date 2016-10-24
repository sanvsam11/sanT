/**
 * Created by SanthoshVarathan on 05/08/16.
 */
public class KMP_class {
    String pat,txt;
    int pl,tl,a[];
    public KMP_class(String pat,String txt){
        this.pat=pat;this.txt=txt;
        pl=pat.length();a=new int[pl];
        tl=txt.length();
    }
    public void refArrayBuilder(){int j=0;a[j]=0;                   //function to build the reference array
        for(int i=1;i<pl;i++){
            if(pat.charAt(i)==pat.charAt(j)){a[i]=++j;}
            else {
                if(j==0) a[i]=j;
                  else j=a[j-1];
            }
        }
    }
    public boolean stringPatternTester(){
        for(int t=0,p=0;t<tl;t++){char ct = txt.charAt(t),cp=pat.charAt(p);
            if(ct==cp){p++;if(p==pl)return true;}
            else if(p>0) p=a[p-1];
        }
    return false;}
    public void printRef(){                                         //function to print
        for(int i=0;i<pl;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String ar[]){
        KMP_class o = new KMP_class("aabyaab","aabaabyaabyaaabyaab");
        o.refArrayBuilder();
        o.printRef();
        System.out.println("Result: "+o.stringPatternTester());

    }
}
