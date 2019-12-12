package workbook;

public class Otab extends Mobile{
	Otab(){
		
	}
	Otab(String mobileName, int batterySize, String osType){
		super(mobileName,batterySize,osType);
	}
	
	public int operate(int time) {
		setBatterySize(getBatterySize()-time*12);
		return getBatterySize();
	}
	
	/*public int operate(int time) { //위의 charge 메소드를 풀어 쓴 메소드
		int result = getBatterySize();
		result -= time*12;
		setBatterySize(result);				
		return getBatterySize();
	}*/
	
	public int charge(int time) {
		setBatterySize(getBatterySize()+time*8);
		return getBatterySize();
	}
	
	/*public int charge(int time) { //위의 charge 메소드를 풀어 쓴 메소드
		int result = getBatterySize();
		result += time*8;
		setBatterySize(result);
		return getBatterySize();
	}*/
}
