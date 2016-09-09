//java program to find kth decrypted character based on
//substring and count pattern
// ab2cd2 = ababcdcd k=4 sol:b

public class decrypted_kth
{
	String encrypted_string;int k;
	public void getEncryptedString(String s){
		encrypted_string=s;
	}
	public boolean isNumber(char c){
		if(c>='0'&&c<='9') return true;
		else return false;
	}
	public char findKthDecryptedChar(){char result='\0';
		StringBuilder substring=new StringBuilder();int l=encrypted_string.length();
		for(int i=0;i<l;i++){char c = encrypted_string.charAt(i);
			if(!(isNumber(c))){
				substring.append(c);
			}
			else {int it=c-'0';if(isNumber(encrypted_string.charAt(i+1)))it=(it*10)+(int)encrypted_string.charAt(i+1);
				if((it*substring.length())>k){k=k%substring.length();result=substring.charAt(k);}
				else{k=k-(it*substring.length());substring.trimToSize();}
			}
		}
	return result;}
	public void getK(int k){this.k=k;}
	public static void main(String ar[]){
		decrypted_kth dk = new decrypted_kth();
		dk.getEncryptedString("a2b3");
	}
}
