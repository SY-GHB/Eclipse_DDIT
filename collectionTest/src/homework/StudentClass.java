package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 문제) 학번, 이름, 국어, 영어, 수학점수, 총점, 등수를 멤버로 갖는 Student 클래스를 만든다.
 * 이  Student클래스의 생성자에서는 학번, 이름, 국어, 영어, 수학점수만 매개변수로 받아 초기화처리를 한다.
 * (총점은 3과목 점수의 합계로 초기화한다.)
 * 
 * 이 Student객체는 List에 저장하여 관리한다.
 * 
 * 1. List에 저장된 데이터들을 학번의 오름차순으로 내부 정렬 기준을 구현하고,
 * 2. 총점의 내림차순으로 정렬하는데, 3. 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스를
 * 작성하여 정렬된 결과를 출력하시오.
 * 
 * (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 * 
 */

public class StudentClass {
	public static void printVar() {
		System.out.println("────────────────────────────────────────────────────────────────────────");
	}
	
	//등수 부여
	public void ranking(ArrayList<Student> stuList) {
		for (Student stu1 : stuList) {
			int rank = 1;
			for (Student stu2 : stuList) {
				if (stu1.getSum() < stu2.getSum()) {
					rank++;
				}
				stu1.setRank(rank);
			}
		}	
	}
	
	
	public static void main(String[] args) {
		ArrayList<Student> stuList = new ArrayList<Student>();
		StudentClass sclass = new StudentClass();

		stuList.add(new Student(2303, "변학도", 90, 90, 90));
		stuList.add(new Student(2302, "성춘향", 95, 30, 70));
		stuList.add(new Student(2305, "이순신", 99, 99, 99));
		stuList.add(new Student(2301, "홍길동", 99, 99, 99));
		stuList.add(new Student(2304, "강감찬", 78, 99, 60));

		sclass.ranking(stuList);
		
		System.out.println("정렬 전");
		for(Student stu : stuList) {
			System.out.println(stu);
		}
		printVar();
		
		Collections.sort(stuList);
		System.out.println("학번 오름차순으로 정렬 후");
		for(Student stu : stuList) {
			System.out.println(stu);
		}
		printVar();
		
		
		Collections.sort(stuList, new SumDesc());
		System.out.println("총점의 내림차순으로 정렬 후 ");
		for(Student stu : stuList) {
			System.out.println(stu);
		}
		printVar();
		
		Collections.sort(stuList, new NameAsc());
		Collections.sort(stuList, new SumDesc());
		System.out.println("총점 내림차순 & 동점자 이름 오름차순 ");
		for(Student stu : stuList) {
			System.out.println(stu);
		}
		printVar();

	}
}



//이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스
class NameAsc implements Comparator<Student>{

	@Override
	public int compare(Student stu1, Student stu2) {
		return stu1.getName().compareTo(stu2.getName());
	}
	
}


class SumDesc implements Comparator<Student>{

	//총점의 내림차순으로 정렬
	@Override
	public int compare(Student stu1, Student stu2) {
		if(stu1.getSum()>stu2.getSum()) {
			return -1;
		}else if(stu1.getSum()<stu2.getSum()) {
			return 1;
		}else {
			return 0;
		}
	}
	
}

class Student implements Comparable<Student>{
	private int Sid;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;
	
	public Student(int sid, String name, int kor, int eng, int math) {
		super();
		Sid = sid;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor+eng+math;
	}
	
	
	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	
	@Override
	public String toString() {
//		sum = (kor + eng + math);
		return "학번: " + Sid + ", 이름: " + name + ", 국어: " + kor + 
				"점, 영어: " + eng + "점, 수학: " + math + "점, 총합: " 
				+ sum +"점, "+rank+"등.";
	}


	// 학번의 오름차순으로 내부 정렬 기준을 구현하자.
	@Override
	public int compareTo(Student stu) {
//		if(this.getSid()<stu.getSid()) {
//			return -1;
//		}else if(this.getSid()>stu.getSid()) {
//			return 1;
//		}else {
//			return 0;
//		}
		
//		return this.getSid()-stu.getSid();
		return Integer.compare(this.getSid(), stu.getSid());
	}
	
}


