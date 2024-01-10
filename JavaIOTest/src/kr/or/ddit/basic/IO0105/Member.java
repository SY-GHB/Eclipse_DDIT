package kr.or.ddit.basic.IO0105;

//java.io.Serializable을 구현해야만 직렬화할 수 있다.
public class Member implements java.io.Serializable{

	private String name;
	private int age;
	//transient를 붙이면 직렬화 대상에서 제외된다.
	//이걸 직렬화-역직렬화해서 객체에서 꺼내면 기본값으로 나온다 -String은 null로 나온다.
	private String adr;
	
	//생성자
	public Member(String name, int age, String adr) {
		super();
		this.name = name;
		this.age = age;
		this.adr = adr;
	}

	//getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}
	
	
	
	

}
