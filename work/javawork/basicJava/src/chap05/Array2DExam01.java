package chap05;
/*
 * 2차원 배열 연습
 * [출력형태]
 * 1  2  3  4  5
 * 6  7  8  9  10
 * 11 12 13 14 15
 * 16 17 18 19 20
 * 21 22 23 24 25
 * 
 * *  2  3  4  5
 * 6  *  8  9  10
 * 11 12 *  14 15
 * 16 17 18 *  20
 * 21 22 23 24 *
*/
public class Array2DExam01 {
	public static void main(String[] args) {
		//1. 2차원 배열을 생성
		int[][] myarr = new int[5][5];
		int i=1;
		//2. 2차원 배열에 값을 저장하기 - setting
		for(int r=0;r<myarr.length;r++) {
			for(int c=0;c<myarr[r].length;c++) {
				myarr[r][c] = i;
				i++;
			}
		}
		//3. 2차원 배열에 저장된 데이터를 출력형태와 같이 출력하기
		for(int r=0;r<myarr.length;r++) {
			for(int c=0;c<myarr[r].length;c++) {
				System.out.print(myarr[r][c]+"\t");
			}
			System.out.println();
		}
		System.out.println("==========================================");
	/*----------------------------------------------------------------*/
		i=1;
		for(int r=0;r<myarr.length;r++) {
			for(int c=0;c<myarr[r].length;c++) {
				myarr[r][c] = i++;
			}
		}
		
		for(int r=0;r<myarr.length;r++) {
			for(int c=0;c<myarr[r].length;c++) {
				if(r==c) {
					System.out.print("*\t");
				}else {
					System.out.print(myarr[r][c]+"\t");
				}
			}
			System.out.println();
		}
	}
}
