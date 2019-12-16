package workbook;

public abstract class Shape02 {
	protected Point point;
	public Shape02() {
		
	}
	public Shape02(Point point) {
		this.point = point;
	}
	public abstract double getArea();
	public abstract double getCircumference();
}
