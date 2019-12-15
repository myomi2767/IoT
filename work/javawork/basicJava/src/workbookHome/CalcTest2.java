package workbookHome;
// 워크북 page 67. 문제2
public class CalcTest2 {
	public static void main(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[2]);
		Calculator calculator = new Calculator();
		if(args.length==3) {
			switch(args[1]) {
				case "+": 
					calculator.plus(num1, num2);
					break;
				case "-": 
					calculator.minus(num1, num2);
					break;
				case "x": 
					calculator.multiplication(num1, num2);
					break;
				case "/": 
					calculator.divide(num1, num2);
					break;
			}
			calculator.print();
		}else {
			System.out.println("다시 입력하세요");
		}
		
	}

}
