package workbook;
//워크북 page55. 문제 2
public class CompanyTest {
	public static void main(String[] args) {
		//Company의 salary가 double이고 입력받은 salary가 int이므로 자동casting이 된다.
		int salary = Integer.parseInt(args[0]);
		Company com = new Company(salary);
		
		System.out.println("연 기본급 합: "+com.getIncome()+" 세후:"+com.getAfterTaxIncome());
		System.out.println("연 보너스 합: "+com.getBonus()+" 세후: "+com.getAfterTaxBonus());
		System.out.println("연 지급액 합: "+(com.getAfterTaxIncome()+com.getAfterTaxBonus()));
	}

}
