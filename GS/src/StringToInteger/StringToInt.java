package StringToInteger;

import java.awt.font.NumericShaper;
import java.util.Scanner;

public class StringToInt {

	public static void main(String[] args) {
		
		String s = null;
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Enter a string to convert : ");
		s = scan.nextLine();
		
		System.out.println("Converted to number");
		convert(s);
		
	}

	public static void convert (String s){
		
		String str = s; 
		char [] c = str.toCharArray();
		
		int number = 0;
		boolean isNegative = false; 
		 int i = 0 ;
		
		 if(c[i] == '-'){
				isNegative = true; 
				i++;
			}
		 
		while (i<str.length()){
			
			number = number*10;
			number = number + c[i]-'0';
			i++;
		}
		
		if(isNegative){
			number = number * -1;
		}
		
		System.out.println("Number is  : " + number);
		number  = number + 20;
		System.out.println("add : " + number);
		
		
	}
	
}
