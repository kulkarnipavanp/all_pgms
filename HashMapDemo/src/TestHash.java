
import java.util.*;
import java.util.Map;

public class TestHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// find occurnace of characters
		
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		
		String str = "aaabbcccc";
		int len = str.length();
		
		hm.put('a', 100);
		hm.put('a', 200);
		hm.put('b', 300);
		hm.put('d', 400);
		
				
		/*System.out.println("hash map contents : " + hm);
		System.out.println("hash map <hm.values> contents : " + hm.values());
		System.out.println("hash map <hm.keys> contents : " + hm.keySet());
		System.out.println("hash map <hm.values> contents : " + hm.entrySet());*/
		
		
		Iterator <Map.Entry<Character, Integer>> it = hm.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Character, Integer> entry = it.next();			
		System.out.print(entry.getKey()+"-->");
		System.out.print(entry.getValue()+"\n");
		}
		
		System.out.println("\nEnd !");
	}

}
