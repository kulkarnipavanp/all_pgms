package Power;

import java.util.Scanner;

public class PowerXY {

	public static void main(String[] args) {

		int x,y;
		Scanner scan = new Scanner(System.in);
		
		//if whole number then we say x is power of y ---> y^x
		
		System.out.println("Enter x : ");
		x = scan.nextInt();
		
		System.out.println("Enter y : ");
		y = scan.nextInt();
		
		power(x,y);
		
	}
	
	public static void power(int x, int y){
		int n=0;
		int t = x/y;
		
		while(x % y == 0){
			x = x/y;
			n++;
		}
		
		if(x == 1)
			System.out.println("it is a power");
		
		else
			System.out.println("not a power");
	}

}
