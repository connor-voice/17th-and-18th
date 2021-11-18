package domain;

public class Dog {

	private String name;
	private String breed;
	private int age;
	private float size;
	private int id;
	
	public Dog() {
		
	}


	
	public Dog(int id, String name, String breed, int age, float size) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.size = size;
		this.id = id;
	}



	public Dog(String name, String breed, int age, float size) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.size = size;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "Dog [name= " + name + "], [breed= " + breed + "], [age= " + age + "], [size= " + size + "], [id= " + id + "]" + "\n";
	}
	
	
	
	
}
