package android.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

//TCP�����ʿ� Ŭ���̾�Ʈ�� ��û�� ��� �д� ������
public class ReceiverThread extends Thread{
	Socket client;
	BufferedReader br;//Ŭ���̾�Ʈ�� �޽����� �д� ��Ʈ��
	PrintWriter pw;//Ŭ���̾�Ʈ���� �޽����� �����ϴ� ��Ʈ��
	SerialArduinoLEDControl serialObj;//�ø�������� ���� ��ü
	OutputStream os;//�ø�����ſ��� �Ƶ��̳�� �����͸� �������� ���� ��Ʈ��
	public ReceiverThread(Socket client) {
		this.client = client;
		try {
			//Ŭ���̾�Ʈ�� �������� �޽����� �б� ���� ��Ʈ�� ����
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			//Ŭ���̾�Ʈ���� �޽����� �����ϱ� ���� ��Ʈ�� ����
			pw = new PrintWriter(client.getOutputStream(), true);
			//�Ƶ��̳�� �ø�������� �ϱ� ���ؼ� �Ƶ��̳�� �����͸� �������� ���� ��Ʈ�����
			serialObj = new SerialArduinoLEDControl();
			serialObj.connect("COM5");
			os = serialObj.getOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		//Ŭ���̾�Ʈ�� �޽����� �޾Ƽ� �Ƶ��̳�� �����͸� ����
		while(true) {
			try {
				String msg = br.readLine();
				System.out.println("Ŭ���̾�Ʈ�� ���� �޽���:"+msg);
				if(msg.equals("led_on")) {
					os.write('1');
				}else {
					os.write('0');
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}