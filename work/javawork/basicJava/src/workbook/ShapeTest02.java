package workbook;

public class ShapeTest02 {
	public static void main(String[] args) {
		Shape02 shape[] =  new Shape02[4];
		shape[0] = new Rectangle02(4, 7, 5);
		shape[1] = new Rectangle02(5, 4, 6);
		shape[2] = new Circle02(6, 6, 7);
		shape[3] = new Circle02(7, 8, 3);
		
		for (Shape02 obj : shape) {
			if(obj instanceof Rectangle02) {
				System.out.println(((Rectangle02)obj).printInfo());
			}else if(obj instanceof Circle02) {
				System.out.println(((Circle02)obj).printInfo());
			}
		}
		
		System.out.println("After Move............");
		for (Shape02 obj : shape) {
			if(obj instanceof Rectangle02) {
				((Rectangle02)obj).move(10, 10);
				System.out.println(((Rectangle02)obj).printInfo());
			}else if(obj instanceof Circle02) {
				((Circle02)obj).move(10, 10);
				System.out.println(((Circle02)obj).printInfo());
			}
		}
	}

}
