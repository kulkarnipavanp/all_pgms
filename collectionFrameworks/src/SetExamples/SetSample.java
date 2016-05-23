package SetExamples;

import java.util.*;


public class SetSample {

	
	public static void main(String[] args) {
	
		Map <String, ArrayList<Person>> hm = new HashMap<String, ArrayList<Person>>();
		
		String department = null;	
	//
		Scanner scan = new Scanner (System.in);
		int choice;
		
			
		do{
		System.out.println("1.Add Entries\n2.Display\n3.Exit");
		 choice = scan.nextInt();
		
		
		switch(choice){
		
		case 1 :  	System.out.println(" enter Department : ");
					department = scan.next();
					ArrayList<Person> people = new ArrayList<Person>(); 
					
					addToEntry(department, people, hm );
					break;
					
				
		case 2 : System.out.println("----- All Data ----- ");
					displayAll(hm);
					break;
				
			}
		}while(choice!=3);
	
		System.out.println("------END------");
	}
	
	public static void addToEntry(String dept, ArrayList<Person> people, Map <String, ArrayList<Person>> hm ){
		
		Person []p = new Person[100];	
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter the number of employees in the dept");
		int count = scan.nextInt();
		
		for(int i=0;i<count;i++){
			p[i] = new Person();
			people.add(p[i].readPerson()); //adding people list 
		}
		
		/*System.out.println("ID\t\tNAME");
		System.out.println("======================================");
		
		Iterator<Person> iterator = people.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
						
		
		System.out.println("adding entries to map  --");
		hm.put(dept, people);
		
		System.out.println("hash map <hm.values> contents : " + hm.values());
		System.out.println("hash map <hm.keys> contents : " + hm.keySet());
		System.out.println("hash map <hm.values> contents : " + hm.entrySet());
		
		
	}
	
	public static void displayAll(Map <String, ArrayList<Person>> hm ){
	
		ArrayList <Person> pList = new ArrayList<Person>();
		Iterator <Map.Entry<String, ArrayList<Person>>> it = hm.entrySet().iterator();
		String d = null;
		
		
		while(it.hasNext()){
			Map.Entry<String, ArrayList<Person>> entry = it.next();			
			
			d = entry.getKey();
			pList = entry.getValue();
				
			System.out.println("Department : " + d);
			System.out.println("ID\t\tNAME");
			System.out.println("===========================");

			Iterator<Person> iterator = pList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
		
	}
	

}
