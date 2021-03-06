package workbook;
//워크북 page55. 문제 2
public class Company {
	private double salary;//기본급
	private double annualIncome;//연소득
	private double afterTaxAnnualIncome;//세금 공제 후 연소득의 합 
	private double bonus;//보너스
	private double afterTaxBonus;//세금 공제 후 연보너스의 합
	
	public Company() {
		
	}
	
	public Company(double salary) {
		this.salary = salary;
	}
	
/*	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}*/
	
	public double getIncome() {
		annualIncome = salary*12;  
		return annualIncome;
	}
	
	public double getAfterTaxIncome() {
		afterTaxAnnualIncome = getIncome() - (getIncome()*10/100);
		//afterTaxAnnualIncome = annualIncome - (annualIncome*10/100); 도 가능
		return afterTaxAnnualIncome;
	}
	
	public double getBonus() {
		bonus = salary*20/100*4;
		return bonus;
	}
	
	public double getAfterTaxBonus() {
		afterTaxBonus = getBonus() - (getBonus()*5.5/100);
		return afterTaxBonus;
	}
}
