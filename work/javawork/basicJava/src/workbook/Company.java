package workbook;
//��ũ�� page55. ���� 2
public class Company {
	private double salary;//�⺻��
	private double annualIncome;//���ҵ�
	private double afterTaxAnnualIncome;//���� ���� �� ���ҵ��� �� 
	private double bonus;//���ʽ�
	private double afterTaxBonus;//���� ���� �� �����ʽ��� ��
	
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
		//afterTaxAnnualIncome = annualIncome - (annualIncome*10/100); �� ����
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