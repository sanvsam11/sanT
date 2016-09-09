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
		StringBuilder substring=new StringBuilder();int l=encrypted_string.length(),i=0;
		while(i<l)
		{
			char c = encrypted_string.charAt(i);
			if(!(isNumber(c)))
			{
				substring.append(c);
			}
			else {
				int it = c - '0';
				while (((i+1)<l)&&isNumber(encrypted_string.charAt(i+1))) {i++;
					it = (it * 10) + (int) encrypted_string.charAt(i);
				}
				if ((it * substring.length()) >= k) {
					k = k % substring.length();
					result = substring.charAt(k);
				} else {
					k = k - (it * substring.length());
					substring.setLength(0);
				}
			}i++;
		}
	return result;}
	public void getK(int k){this.k=k;}
	public static void main(String ar[]){
		decrypted_kth dk = new decrypted_kth();
		dk.getEncryptedString("a2b3");
		dk.getK(4);
		System.out.println("Result:"+dk.findKthDecryptedChar());
	}
}
