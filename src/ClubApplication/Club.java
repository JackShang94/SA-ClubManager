package ClubApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Club {
	private ArrayList<Member> members = new ArrayList<Member>();
	private HashMap<String, Facility> facilities;

	public Club() {
		members = new ArrayList<Member>();
		facilities = new HashMap<String, Facility>();
	}

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

	public Facility getFacility(String Name) {
		return facilities.get(Name);

	}

	public List<Facility> getFacilities() {
		ArrayList<Facility> result;
		result = new ArrayList<Facility>(facilities.values());
		Collections.sort(result);
		return (result);
	}

	public void addFacility(String name, String description) {
		if (name == null) {
			return;
		}
		Facility f = new Facility(name, description);
		facilities.put(name, f);
	}

	public void removeFacility(String name) {
		facilities.remove(name);
	}

	public void showFacilities() {
		Iterator<Facility> i = getFacilities().iterator();
		while (i.hasNext()) {
			i.next().show();
		}
	}
	public void show() {
		System.out.println("Current Members:");
		showMembers();
		System.out.println();
		System.out.println("Facilities:");
		showFacilities();
	}
}
