package workbook;

public class ShapeTest {
	public static void main(String[] args) {
		//Shape타입의 객체를 참조할 수 있는 변수 6개를 배열로 생성
		Shape shape[] = new Shape[7];
		shape[0] = new Triangle(7,5,"Blue");
		shape[1] = new Rectangle(4,6,"Blue");
		shape[2] = new Triangle(6,7,"Red");
		shape[3] = new Rectangle(8,3,"Red");
		shape[4] = new Triangle(9,8,"White");
		shape[5] = new Rectangle(5,7,"White");
		shape[6] = new Circle(0,0,"White",5);
		
		System.out.println("기본정보");
		for (int i = 0; i < shape.length; i++) {
			if(shape[i] instanceof Triangle) {
				System.out.print("Triangle\t");
			}else if(shape[i] instanceof Rectangle){
				System.out.print("Rectangle\t");
			}else {
				System.out.print("Circle\t");
			}
			//System.out.println(shape[i].getClass().getName()+"\t"
			//						+shape[i].getArea()+"\t"+shape[i].getColors());
			System.out.println(shape[i].getArea()+"\t"+shape[i].getColors());
		}
		
		System.out.println("\n사이즈를 변경 후 정보");
		for (int i = 0; i < shape.length; i++) {
			if(shape[i] instanceof Triangle) {
				((Triangle)shape[i]).setResize(5);
				System.out.print("Triangle\t");
			}else if(shape[i] instanceof Rectangle){
				((Rectangle)shape[i]).setResize(5);
				System.out.print("Rectangle\t");
			}else {
				System.out.print("Circle\t");
			}
			System.out.println(shape[i].getArea()+"\t"+shape[i].getColors());
		}
		//향상된 for문 - 5.0부터 추가된 for문
		//배열이나 collection을 다룰 때 사용
		//for문이 한 번 실행될 때 마다 shape배열에서 요소 하나씩 꺼내서 obj에 전달 후 작업
		/*for (Shape obj : shape) {
			System.out.println(obj.getColors());//obj = shape[i]
			//객체의 타입을 변경하는 경우 무조건 변경하는 것이 아니라 객체의 타입을 체크한 후에 변경한다.
			if(obj instanceof Rectangle) {
				((Rectangle)obj).setResize(5);
			}else {
				((Rectangle)obj).setResize(5);
			}
			//System.out.println(obj.getClass().getName()+"\t"
			//						+obj.getArea()+"\t"+obj.getColors());

		}*/
	}

}
