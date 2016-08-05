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
    public void refArrayBuilder(){int j=0;a[j]=0;
        for(int i=1;i<pl;i++){
            if(pat.charAt(i)==pat.charAt(j)){j++;a[i]=j;}
            else {
                if(j==0) a[i]=j;
                  else j=a[j-1];
            }
        }
    }
    public void printRef(){
        for(int i=0;i<pl;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String ar[]){
        KMP_class o = new KMP_class("ABABCABAB","ABABDABACDABABCABAB");
        o.refArrayBuilder();
        o.printRef();
    }
}
