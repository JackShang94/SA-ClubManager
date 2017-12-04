package ClubApplication;

public class Member extends Person implements Comparable<Member>{
	private Integer memberNumber;

	public Member(String surName, String firstName, String secondName, Integer memberNumber) {
		super(firstName, secondName, surName);
		this.memberNumber = memberNumber;
	}

	public Integer getMemberNumber() {
		return memberNumber;
	}

	@Override
	public String toString() {
		return memberNumber + "-" + super.toString();
	}
	
    //  Added so that Members can be sorted by membership number
    public int compareTo (Member other) {
        return (getMemberNumber() - other.getMemberNumber());
    }


}
