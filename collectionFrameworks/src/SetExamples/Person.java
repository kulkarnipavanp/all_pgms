package SetExamples;

import java.util.Scanner;

public class Person {
	
	int id;
	String name; 
	
	public static int count;
	
	Person(){
		id = 0;
		name = null;
		count++;
		
	}
	
	Person(int id, String name){
		
		this.id = id;
		this.name = name;
		
	}
	
	public Person readPerson(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the person name : ");
		this.name = scan.next();
		
		System.out.println("Enter person id : ");
		this.id = scan.nextInt();
		
			
		return this;
	}
	
	
	@Override
	public String toString() {
	 
		return(id+"\t\t"+name);
	
		 
	}

}
