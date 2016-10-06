package seproject2Class;

public class Author {
	
	private String name;
	private int age;
	private String country;
	
	public Author(String n,int a,String c){
		name = n;
		age = a;
		country = c;
	}
	
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
