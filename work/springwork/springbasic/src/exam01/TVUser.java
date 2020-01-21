package exam01;

public class TVUser {
	public static void main(String[] args) {
		TV tv = new SamsungTV();
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
		
		TV lgtv = new LgTV();
		lgtv.turnOn();
		lgtv.soundUp();
		lgtv.soundDown();
		lgtv.turnOff();
	}

}
