import java.io.*;
import java.util.*;



public class FileOpSample {

	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(new FileReader("test.txt"));

        HashMap<String, String> map = new HashMap<String, String>();

        while (scanner.hasNextLine()) {
            String[] columns = scanner.nextLine().split("\\.");
            System.out.println("column 0 : " + columns[0]);
            System.out.println("column 1 : " + columns[1]);
            map.put(columns[0], columns[1]);
        }

     System.out.println(map);
	
	}

}
