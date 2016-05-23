import java.util.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import java.sql.*;

public class Main 
{
  public static void main(String[] args) throws Exception
	 {
	  ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("DataCon.xml");  
	  Myhiberinterface obj=(Myhiberinterface)ctx.getBean("eventDao");
	
	  Scanner sc=new Scanner(System.in);		  
	  Event event = new Event();
		  	
	   System.out.println("Enter event name");
		event.setName(sc.nextLine());
		
		java.util.Date d=new java.util.Date();
		event.setStartDate(d);
      
		System.out.println("Enter event duration");
		event.setDuration(sc.nextInt());	
		
		obj.addRecord(event);		

	  /*
 System.out.println("Enter event id ");
	  
	  	int id=sc.nextInt();
	     Event e1=obj.findRecord(id);
	     if(e1!=null)
	     {	    
		System.out.println("EID. : " + e1.getId());
		System.out.println("Name : " + e1.getName());
		System.out.println("StartDate: " + e1.getStartDate());
		System.out.println("Duration : " + e1.getDuration());
		if(e1.getId()==id)
		{
		System.out.println("ENter updated duration time");
		int time=sc.nextInt();
		e1.setDuration(time);	
		obj.updateRecord(e1);
		//obj.deleteRecord(e1);
		}
		
	   }
	     else
	   System.out.println("No record found");
*/
			
//STORE RECORDS IN TABLE
	 
//FINDING ALL RECORDS FROM TABLE
	/*List list=obj.findAll();	
	Iterator it = list.iterator();
	while( it.hasNext())
	{
	System.out.println();
	Event e1 = (Event)it.next();
	System.out.println("EID. : " + e1.getId());
	System.out.println("Name : " + e1.getName());
	System.out.println("StartDate: " + e1.getStartDate());
	System.out.println("Duration : " + e1.getDuration());	
	Thread.sleep(1000);
	}*/
  }
 }