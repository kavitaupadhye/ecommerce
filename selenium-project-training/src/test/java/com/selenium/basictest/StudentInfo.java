package com.selenium.basictest;

class Student {

	static int id = 101;
	static String name = "Jones";
	static int marks = 90;

	public  void showInfo() {

		System.out.println("id : " + id + " | Name : " + name + " | Marks : " + marks);
	}

}

interface Marks{
	
	public void gradeA();
	public void gradeB();
	public void gradeC();
}

class MarksCode implements Marks {

	@Override
	public void gradeA() {
		
		System.out.println("Marks between 60-75 ");
		
	}

	@Override
	public void gradeB() {
		System.out.println("Marks between 45-59 ");

	}

	@Override
	public void gradeC() {
		System.out.println("Marks between 35-34 ");
		
	}
	
}

public class StudentInfo {

	public static void main(String[] args) {

	Student s = new Student(); // direct instance - > s created
		s.showInfo();
		s.id=1;
		
		
	//	Student.showInfo();
		
		
		
		
//		Marks a=new Marks();
		
		Marks m=new MarksCode(); // m is craeted with help of implement class (marks code)
		
		m.gradeA();
		m.gradeB();
		m.gradeC();
		
		
		
		MarksCode m1=new MarksCode();
		
		m1.gradeA();
		m1.gradeB();
		m1.gradeC();
	}
	

}
