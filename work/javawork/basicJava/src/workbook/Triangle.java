package workbook;

public class Triangle extends Shape implements Resize{
	public Triangle() {
		
	}
	public Triangle(int width, int height, String colors) {
		super(width,height,colors);
	}
	
	@Override
	public double getArea() {
		double result = getWidth()*getHeight()/2.0;
		return result;
	}
	
	public void setResize(int size) {
		setHeight(getHeight()+size);
	}
	
}
