package workbook;

public class Rectangle02 extends Shape02 implements Movable {
	private int width;
	public Rectangle02() {
		
	}
	public Rectangle02(int width, int x, int y) {
		super(new Point(x,y));
		this.width = width;
	}
		
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public double getArea() {
		return width*width;
	}

	@Override
	public double getCircumference() {
		return width*4;
	}
	
	@Override
	public void move(int x, int y) {
		point.setX(point.getX()+(x+2));
		point.setY(point.getY()+(y+2));
	}
	
	public String printInfo() {
		String name = "Rectangle:\t"+getWidth()+"\t"+point.getX()+"\t"+point.getY();
		return name;
	}

}
