package ClubApplication;

public class Person {
	private String surName;
	private String firstName;
	private String secondName;

	public Person(String firstName, String secondName, String surName) {
		this.surName = surName;
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public String getSurName() {
		return surName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	@Override
	public String toString() {
		return firstName + " " + secondName + " " + surName;
	}

	public void show() {
		System.out.println(toString());
	}
}
