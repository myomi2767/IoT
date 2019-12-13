package oop.chap07;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student("Kim",25,100,90,95,89);
		Student s2 = new Student("Lee",20,60,70,99,98);
		Student s3 = new Student("Park",19,68,86,60,40);
		
		Teacher t1 = new Teacher("Àåµ¿°Ç",45,"Spring");
		Staff e = new Staff("±è¼­¿¬",25,"Àü»ê½Ç");
		
		s1.print();
		s2.print();
		s3.print();
		t1.print();
		e.print();
		
		/*System.out.println(s1.getName()+"Æò±Õ:"+s1.getAvg()+"ÇÐÁ¡:"+s1.getGrade());
		System.out.println(s2.getName()+"Æò±Õ:"+s2.getAvg()+"ÇÐÁ¡:"+s2.getGrade());
		System.out.println(s3.getName()+"Æò±Õ:"+s3.getAvg()+"ÇÐÁ¡:"+s3.getGrade());*/
		
	}

}
