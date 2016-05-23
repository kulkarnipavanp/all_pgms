package mytest;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//import com.mysql.jdbc.ResultSetMetaData;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan_schema", "root","root");
			
			System.out.println("\nSuccessfully connected");
			
			int ch=0;
			
			String name,add,date;
			
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			CallableStatement csInsert = con.prepareCall("{call insertPerson(?,?,?,?,?)}");
			CallableStatement csUpdate = con.prepareCall("{call updatePerson(?,?,?,?,?)}");
			//CallableStatement csRetrieve = con.prepareCall("{call getPerson(?,?,?,?)}");
			
			/*PreparedStatement psInsert = con.prepareStatement("insert into Persons values(?,?,?,?)");
			PreparedStatement psUpdate = con.prepareStatement("update Persons set id=?, LastName=?, FirstName=?, Address=?, City=? where Id=?");
			*/
			
			do
			{
				System.out.println("1. Insert Data\n2. Show All \n3. Update");
				ch = input.nextInt();
				
				
				switch(ch)
				{
				case 1:
					System.out.println("Enter the Person id : ");
					int id=input.nextInt();
					
					System.out.println("Enter the Person first name : ");
					String fName=input.next();
					
					System.out.println("Enter the Person last name : ");
					String lName=input.next();
					
					System.out.println("Enter the address : ");
					String address = input.next();
					
					System.out.println("Enter the City : ");
					String city = input.next();
					
					csInsert.setInt(1, id);
					csInsert.setString(2, fName);
					csInsert.setString(3, lName);
					csInsert.setString(4, address);
					csInsert.setString(5, city);
					
					csInsert.execute();
					
					System.out.println("== insert successfull ==");
					break;
					
				case 2:
					
					System.out.println("All People : ");
					
					ResultSet rs=st.executeQuery("select * from Persons");
					
					ResultSetMetaData md = rs.getMetaData();
					
					for(int i=1;i<=md.getColumnCount();i++)
						System.out.print(md.getColumnName(i)+"\t");
						
					System.out.println();
					
					while(rs.next())
					{
						for(int i=1;i<=md.getColumnCount();i++)
							System.out.print(rs.getString(i)+"\t");
						System.out.println();
					}
					break;
					
				case 3:
					System.out.println("Enter the id person to be updated : ");
					 int n_id = input.nextInt();
					
						
							System.out.println("Enter the new fisrt name : ");
							String n_fName = input.next();
							
							
							System.out.println("Enter the new last name : ");
							String n_lName = input.next();
							
							System.out.println("Enter the new address : ");
							String n_address = input.next();
							
							
							System.out.println("Enter the new city : ");
							String n_city = input.next();
							
							
							csUpdate.setInt(1, n_id);
							csUpdate.setString(2, n_fName);
							csUpdate.setString(3, n_lName);
							csUpdate.setString(4, n_address);
							csUpdate.setString(5, n_city);
							
													
							csUpdate.execute();
							
							System.out.println("update done ! ");
							
											
					break;
				}	
				
			}while(ch<4);
			
			con.close();
			System.out.println("---EXIT---");
			input.close();
			 
		}	
		catch (Exception e)
		{

			e.printStackTrace();
		}
	}
}