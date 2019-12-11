package workbook;

public class Company {
	private double salary;
	private double annualIncome;
	private double afterTaxAnnualIncome;
	private double bonus;
	private double afterTaxBonus;
	
	public Company() {
		
	}
	
	public Company(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	public double getIncome() {
		annualIncome = salary*12;  
		return annualIncome;
	}
	
	public double getAfterTaxIncome() {
		afterTaxAnnualIncome = getIncome() - (getIncome()*10/100);
		return afterTaxAnnualIncome;
	}
	
	public double getBonus() {
		bonus = salary*20*4/100;
		return bonus;
	}
	
	public double getAfterTaxBonus() {
		afterTaxBonus = getBonus() - (getBonus()*5.5/100);
		return afterTaxBonus;
	}
}
