import java.util.*;


public class Customer {
	
	static int count = 0;
	int cid;
	String cname, email;
	long phno;


	public Customer() {
		// TODO Auto-generated constructor stub
		this.cid = 0;
		this.cname = null;
		this.email = null;
		this.phno = 0;
		
		count++;
	}
		
	public void readData()
	{
		System.out.println("number of customers <inside read_data()> : " + count);
				
			//Scanner scan_str = new Scanner(System.in);
			Scanner scan = new Scanner(System.in);
						
			System.out.println("Enter cname : " );
			String name = scan.nextLine(); 
			this.cname = name;
			
			System.out.println("Enter cid : " );
			int id = scan.nextInt();
			this.cid = id;
			
			System.out.println("Enter email : ");
			String e = scan.next();
			this.email = e;
			
			System.out.println("Enter phno : " );
			long pno = scan.nextLong();
			this.phno = pno;
					
	}
	
	
	public void displayData()
	{
		System.out.println(cid+"\t\t"+cname+"\t\t"+phno+"\t\t"+email);
		
	}
		

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = count;
		Scanner input = new Scanner(System.in);
		System.out.println("count = " + count);
		
		Customer [] cust = new Customer[100];
		int choice; 
		
		do{
			
			System.out.println("MENU : \n 1. Add Customer \n 2. Display All\n3. EXIT \n ENter your choice : ");
			choice = input.nextInt();
			
			switch(choice){
			case 1 : //System.out.println("do u wish to create more customers (y/n) : ");
							
						/*System.out.println("choice = " + choice);
						if(choice.equals("n"))
							break;*/
			
						cust[n] = new Customer();
						cust[n].readData();
						n++;
			
						System.out.println("value of n from main : " + n);
						break;
			
			case 2 : 	System.out.println("printing all customer : \n");
						System.out.println("CID\t\tCNAME\t\tPh No.\t\tEMAIL \n =====================================================================\n");
		
						for(int i=0;i<n; i++)
							cust[i].displayData();
							break;
					
			}//end of switch
		}while(choice != 3);//end of while
		
		input.close();
	}//end of main
}//end of class


