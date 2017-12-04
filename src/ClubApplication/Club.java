package ClubApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Club {
	private ArrayList<Member> members = new ArrayList<Member>();
	private HashMap<String, Facility> facilities;
	public Member addMember(String surName, String firstName, String secondName) {

		Member member = new Member(surName, firstName, secondName, members.size() + 1);
		members.add(member);
		return member;
	}

	public ArrayList<Member> getMembers() {
		ArrayList<Member> result;
		result = new ArrayList<Member>(members);
		Collections.sort(result);
		return (result);
	}

	public Member getMember(int memberNum) {
		Iterator<Member> i = members.iterator();
		while (i.hasNext()) {
			Member m = i.next();
			if (m.getMemberNumber() == memberNum) {
				return m;
			}
		}
		return null;
	}

	public void showMembers() {
		Iterator<Member> i = members.iterator();
		while (i.hasNext()) {
			i.next().show();
		}
	}

	public void removeMember(int memberNumber) {
		// if ((memberNumber < 1) || (memberNumber > members.size())) {
		// return;
		// }
		// members.remove(memberNumber - 1);

		Member member = getMember(memberNumber);
		if (member != null) {
			members.remove(member);
		}
	}
	
	public  List<Facility> getFacilities() {
		ArrayList<Facility> result;
		result = new ArrayList<Facility>(facilities.values());
		Collections.sort(result);
		return(result);
	}
}
