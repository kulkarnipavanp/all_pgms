package example;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeClient {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();


		Scanner input = new Scanner(System.in);

		int ch;

		do{

			System.out.println("1. insert \n2. show \n3. update\n4. delete\n5. exit");
			System.out.println("enter ur choice : ");
			ch = input.nextInt();

			switch(ch){

			case 1 :  
				Employees e = new Employees();
				
				/*System.out.println("enter eid : ");
				int id = input.nextInt();
				e.setEid(id);
				*/
				System.out.println("enter first name : ");
				String fname = input.next();
				e.setFirstName(fname);
				
				System.out.println("enter last name : ");
				String lname = input.next();
				e.setLastName(lname);
				
				System.out.println 
				("The employee " + e.getFirstName()+ " " 
						+ e.getLastName()+" is successfully added to your database");

				session.save(e);
			

				break;

			case 2 :

				Query q = session.createQuery("from Employees as e");
				List <Employees> l = q.list();

				Iterator<Employees> it = l.iterator();

				while(it.hasNext()){
					Employees e1 = it.next();
					System.out.println(e1.getEid()+"\t" +e1.getFirstName()+"\t"+e1.getLastName());
				}
				break;

			case 3 : System.out.println("update");
			break; 
			
			case 4 : System.out.println("delete");
			Query q1 = session.createQuery("delete from Employees as e where e.id = ?");
			
			System.out.println("enter eid to delete : ");
			int eid_del = input.nextInt();
			
			q1.setInteger(0, eid_del);
			int res = q1.executeUpdate();
			
			if(res>0)
				System.out.println("record deleted successfully !!");
			else
				System.out.println("record not found");
			 break;
			
			case 5 :  System.out.println("exit");
			
			
			}
		} while(ch<5) ;

		tx.commit();
		session.close();
		sessionFactory.close();

	}
}
