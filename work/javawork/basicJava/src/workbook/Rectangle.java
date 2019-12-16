package workbook;

public class Rectangle extends Shape implements Resize{
	public Rectangle() {
		
	}
	public Rectangle(int width, int height, String colors) {
		super(width,height,colors);
	}
	
	@Override
	public double getArea() {
		double result = (double)getWidth()*getHeight(); 
		return result;
	}
	
	public void setResize(int size) {
		setWidth(getWidth()+size);
	}
}
