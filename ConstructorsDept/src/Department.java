import java.util.Scanner;


public class Department {
	
	int dId; 
	String dName, dLocation;
	
	Department(){
		dId = 10;
		dName = "the default department";
		dLocation = "Timbaktoo";
	}
	
	Department(int id, String name){
		this();
		this.dId = id;
		this.dName = name;
		
	}

	public void readAll(){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("enter name : ");
		this.dName = in.nextLine();
		
		System.out.println("enter id : ");
		this.dId = in.nextInt();
		
		
	}
	
	public void displayAll(){
		System.out.println(dId+"\t\t"+dName+"\t\t"+dLocation);
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Department [] dept = new Department[20];
		
		Scanner input = new Scanner(System.in);
		int choice, nDefault =0, nCustom=0,i,j; 
		i=j=0;
		int n=0;
		int x,y;
		
		do{
			
			System.out.println("MENU : \n1. Default Initialization \n2. Custom Initialization\n3. Display All\n4. EXIT \n ENter your choice : ");
			choice = input.nextInt();
			
			switch(choice){
			
			case 1 : 	System.out.println("Enter # of Departments <default> : ");
						nDefault = input.nextInt();
											
						for(i=0; i<nDefault;i++){
							dept[n] = new Department();
							n++;
						}
						
								
						break;
						
			case 2 :	System.out.println("Enter # of Departments <custom> : ");
						nCustom = input.nextInt();
											
						for(j=0; j<nCustom;j++){
							dept[n] = new Department();
							dept[n].readAll();
							n++;
						}
							
				
						break;
			
			case 3 : 	System.out.println("value of n = "+ n);
						int total = nDefault + nCustom;
						System.out.println("total = " + total);
				
						System.out.println("printing all Departments : \n");
						System.out.println("ID\t\tName\t\tLocation \n =====================================================================\n");
								
						for(i=0;i<n; i++)
							dept[i].displayAll();
							
						break;
					
			}//end of switch
		}while(choice != 4);//end of while
		
		input.close();
		
		
	}

}
