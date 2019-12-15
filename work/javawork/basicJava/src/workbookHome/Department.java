package workbookHome;

public class Department extends Evaluation{
	private String name;
	
	public Department() {
		
	}
	
	public Department(String name, double evaluationA, double evaluationB, double evaluationC, 
			double evaluationD, double evaluationE) {
		
		super(evaluationA, evaluationB, evaluationC, evaluationD, evaluationE);
		this.name = name;
		
	}
	
	public double evaluationNumber() {
		double result = ((getEvaluationA()+getEvaluationB())/2*0.55)+((getEvaluationC()+getEvaluationD())/2*0.25)+(getEvaluationE()*0.2);
		return result;
	}
	
	public void print() {
		System.out.print(name);
		super.print();
	}
	
	
}
