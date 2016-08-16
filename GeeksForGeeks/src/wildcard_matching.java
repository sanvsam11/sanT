/**
 * Created by SanthoshVarathan on 12/08/16.
 */
public class wildcard_matching {
    String pat,txt;int pl,tl;boolean match=true;
    public wildcard_matching(String pat,String txt){
        this.pat=pat;this.txt=txt;
        pl=pat.length();tl=txt.length();
    }
    public void check(){
        for(int i=0,j=0;j<pl;j++){
            if(pat.charAt(j)=='*'){if(j==(pl-1)) break;
                while(pat.charAt(j)=='*')j++;
                while(pat.charAt(j)!=txt.charAt(i))i++;
            }
            if(i==(tl-1)&&j!=(pl-1)) i=i-(pl-j-1);
            else if(j==(pl-1)&&i==(tl-1)) {match=false;break;}
            else if(pat.charAt(j)!=txt.charAt(i)){match=false;break;}
            else i++;
        }
    }
    public static void main(String ar[]){
        String txt="Santhosh",pat="*ant*s";
        wildcard_matching wm = new wildcard_matching(pat,txt);
        wm.check();
        System.out.println("Result:"+wm.match);
    }
}
