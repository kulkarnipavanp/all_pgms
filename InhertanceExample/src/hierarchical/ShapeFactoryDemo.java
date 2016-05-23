package hierarchical;

import java.util.*;

public class ShapeFactoryDemo extends ShapeFactory {

	public static void main(String[] args) {

		ShapeFactory sf = new ShapeFactory();
		String desiredShape;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the shape : ");
		desiredShape = input.nextLine();
		
		sf.getShape(desiredShape);
		
		
	}

}
