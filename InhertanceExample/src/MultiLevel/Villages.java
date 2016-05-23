package MultiLevel;

public class Villages extends Districts {
	
	public void makeRoadVillageWide(){
		System.out.println("Making Roads in Villages  !!");
		
		makeRoadDistrictWide();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Villages v = new Villages();
		
		v.makeRoadVillageWide();
		
		

	}

}
