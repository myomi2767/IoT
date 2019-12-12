package workbook;

public class MobileTest {
	public static void main(String[] args) {
		Ltab Ltab = new Ltab("Ltab", 500, "AP-01");
		Otab Otab = new Otab("Otab", 1000, "AND0-20");
		
		System.out.println("Mobile\t\tBattery\t\tOS");
		System.out.println("--------------------------------------------------");
		System.out.println(Ltab.getMobileName()+"\t\t"+Ltab.getBatterySize()+"\t\t"+Ltab.getOsType());
		System.out.println(Otab.getMobileName()+"\t\t"+Otab.getBatterySize()+"\t\t"+Otab.getOsType());
		System.out.println();
		
		Ltab.charge(10);
		Otab.charge(10);
		
		System.out.println("10분 충전");
		System.out.println("Mobile\t\tBattery\t\tOS");
		System.out.println("--------------------------------------------------");
		System.out.println(Ltab.getMobileName()+"\t\t"+Ltab.getBatterySize()+"\t\t"+Ltab.getOsType());
		System.out.println(Otab.getMobileName()+"\t\t"+Otab.getBatterySize()+"\t\t"+Otab.getOsType());
		System.out.println();
		
		Ltab.operate(5);
		Otab.operate(5);
		
		System.out.println("5분 통화");
		System.out.println("Mobile\t\tBattery\t\tOS");
		System.out.println("--------------------------------------------------");
		System.out.println(Ltab.getMobileName()+"\t\t"+Ltab.getBatterySize()+"\t\t"+Ltab.getOsType());
		System.out.println(Otab.getMobileName()+"\t\t"+Otab.getBatterySize()+"\t\t"+Otab.getOsType());
	}

}
