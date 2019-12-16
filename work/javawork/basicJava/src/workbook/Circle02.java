package workbook;

public class Circle02 extends Shape02 implements Movable{
	private int radius;
	public Circle02() {
		
	}
	public Circle02(int radius, int x, int y) {
		super(new Point(x,y));
		this.radius = radius;
	}
		
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return radius*radius*Math.PI;
	}
	
	@Override
	public double getCircumference() {
		return radius*Math.PI*2;
	}
	
	@Override
	public void move(int x, int y) {
		point.setX(point.getX()+(x+1));
		point.setY(point.getY()+(y+1));
	}
	
	public String printInfo() {
		String name = "Circle:\t\t"+getRadius()+"\t"+point.getX()+"\t"+point.getY();
		return name;
	}
}
