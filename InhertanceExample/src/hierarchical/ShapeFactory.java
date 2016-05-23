package hierarchical;

public class ShapeFactory {
	
	public void getShape(String str){
		
		Shape s = null;
		
		if(str.equalsIgnoreCase("circle"))
			s = new Circle();
			
		else if (str.equalsIgnoreCase("triangle"))
			s = new Triangle();
		
		else if(str.equalsIgnoreCase("rectangle"))
			s = new Rectangle();
		
		else
			s = new Shape();
		
		s.draw();
	}

}
