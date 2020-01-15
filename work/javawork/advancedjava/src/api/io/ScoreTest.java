package api.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ScoreTest {
	public static void main(String[] args) {
		//BufferedReader를 사용
		//항상 두 컬럼으로 고정
		/*
		 *	[출력형태]
		 *	이민호의 점수는 100점
		 *	현빈의 점수는 98점
		 *	김범룡의 점수는 99점
		 *	총점:____
		 *	평균:____ 
		 */	
		BufferedReader br = null;
		int sum = 0;
		double avg = 0;
		int count = 0;
		String[] str = null;
		try {
			br = new BufferedReader(new FileReader("src/data/score.txt"));
			while(true) {
				String data = br.readLine();
				if(data==null) {
					break;
				}
				count++;
				str = data.split(",");
				System.out.println(str[0]+"의 점수는"+str[1]);
				sum += Integer.parseInt(str[1]);
			}
			avg = sum/count;
			System.out.println("총점:"+sum);
			System.out.println("평균:"+avg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null)br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
