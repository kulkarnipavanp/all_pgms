package single;

import java.util.*;

public class Student extends Person {

	int id; 
	String dept; 
	
	public void showAll(){
		System.out.println(name+"\t\t"+age+"\t\t"+id+"\t\t"+dept);
	}
	
	public void readData(){
		
		Scanner input_int = new Scanner(System.in);
		Scanner input_str = new Scanner(System.in);
		
		System.out.println("enter name : ");
		this.name = input_str.nextLine();
		
		System.out.println("enter age : ");
		this.age = input_int.nextInt();
		
		System.out.println("enter id : ");
		this.id = input_int.nextInt();
		
		System.out.println("enter department : ");
		this.dept = input_str.nextLine();
		
		
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student [] s = new Student[10];
		
		int n; 
		Scanner in = new Scanner(System.in);
		
		System.out.println("enter number of students : ");
		n = in.nextInt();
		
		for(int i=0;i<n;i++)
			s[i] = new Student();
		
		for(int i=0;i<n;i++)
			s[i].readData();
		
		for(int i=0;i<n;i++)
			s[i].showAll();		
		

	}

}
