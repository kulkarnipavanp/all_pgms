package sample;


import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;


public class FileOp {
	
	
	/*public static class testing extends TimerTask{
		public void run(){
			System.out.println("printing hello");
		}
		
	}*/
	
	public static Map<String, String> map = new HashMap<String, String>();

    public static List<String> db = new ArrayList<String>();
    public static List<String> table = new ArrayList<String>();
	
	public static void validate() throws Throwable{
		try{
		String filePath = "new.txt";
	    
	    		          
	    Scanner scanner = new Scanner(new FileReader(filePath));
	    
	    while (scanner.hasNextLine()) {
            String[] col = scanner.nextLine().trim().split("\\.");
            
            System.out.println("col length  : " + col.length);
            
            if (col.length == 2){
            	
            	System.out.println("col 0 : " + col[0]);
            	System.out.println("col 1 : " + col[1]);
            	
            	db.add(col[0]);
            	table.add(col[1]);
            	
                map.put(col[0], col[1]);
            }
        }
	       
	    
	    
	    System.out.println("Map : " + map); 
	    
	    
	    System.out.println("\n\nDatabase array List : \n\n" + db);
	    System.out.println("\n\nTable array List : \n\n" + table);

	    System.out.println("\n\n");
	    for (String key : map.keySet())
	    	System.out.println( key + ":" + map.get(key));
    
	   /* for(int i=3;i>0;i--){
	    	System.out.println("\n\n==========\n\n");
	    	Timer timer = new Timer();
	    	timer.schedule(new testing(), 0, 4000);
	    }*/

	    scanner.close();
		}
		finally{
			
			System.out.println("inside finally");
		}
	}
	
	
	public void runQuery(){
		
		
		
	}

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		validate();	
			
	}
	
	

}
