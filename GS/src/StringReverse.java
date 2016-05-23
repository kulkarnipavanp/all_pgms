
import java.util.*;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = null; 
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter string : ");
		str = scan.nextLine();
		
		System.out.println("reversed string is  : ");
		Reverse(str);
		
		
	}
	
	public static void Reverse(String s){
		
		//System.out.println("s = " + s);
		String s1 = s;
		//System.out.println("s1 = " + s1);
		char [] c = s1.toCharArray();
		char t;
		
		int i=0;
		int j = s1.length()-1;
		
		while(i<j){
			
			t = c[i];
			c[i] = c[j];
			c[j] = t;
			
			i++;
			j--;
			
		}
		
		for(int k=0;k<s.length();k++)
			System.out.print(c[k]);
		
	}
		

}
