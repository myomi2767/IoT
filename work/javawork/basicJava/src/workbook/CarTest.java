package workbook;

public class CarTest {
	public static void main(String[] args) {
		Car[] car = new Car[2];
		car[0] = new L3("L3","1500",50,25,0);
		car[1] = new L5("L5","2000",75,35,0);
		
		System.out.println("vehicleName\tengineSize\toilTank\t"
								+ "oilSize\tdistance\ttemperature");
		System.out.println("------------------------------------------------------"
								+ "------------------------");
		for (Car obj : car) {
			System.out.print(obj.getName()+"\t"+obj.getEngine()+"\t"+obj.getOilTank()
								+"\t"+obj.getOilSize()+"\t"+obj.getDistance()+"\t");
			
			if(obj instanceof L3) {
				System.out.println(((L3)obj).getTempGage());
			}else if(obj instanceof L5) {
				System.out.println(((L5)obj).getTempGage());
			}
			
		}
		
		System.out.println("25 주유");
		System.out.println("vehicleName\tengineSize\toilTank\t"
				+ "oilSize\tdistance\ttemperature");
		System.out.println("------------------------------------------------------"
				+ "------------------------");
		
		for (Car obj : car) {
			obj.setOil(25);
			System.out.print(obj.getName()+"\t"+obj.getEngine()+"\t"+obj.getOilTank()
								+"\t"+obj.getOilSize()+"\t"+obj.getDistance()+"\t");
			
			if(obj instanceof L3) {
				System.out.println(((L3)obj).getTempGage());
			}else if(obj instanceof L5) {
				System.out.println(((L5)obj).getTempGage());
			}
			
		}
		
		System.out.println("80 주유");
		System.out.println("vehicleName\tengineSize\toilTank\t"
				+ "oilSize\tdistance\ttemperature");
		System.out.println("------------------------------------------------------"
				+ "------------------------");
		for (Car obj : car) {
			obj.go(80);
			System.out.print(obj.getName()+"\t"+obj.getEngine()+"\t"+obj.getOilTank()
								+"\t"+obj.getOilSize()+"\t"+obj.getDistance()+"\t");
			
			if(obj instanceof L3) {
				System.out.println(((L3)obj).getTempGage());
			}else if(obj instanceof L5) {
				System.out.println(((L5)obj).getTempGage());
			}
			
		}
		
		
	}

}
