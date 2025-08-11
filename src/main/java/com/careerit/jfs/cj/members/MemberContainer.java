package com.careerit.jfs.cj.members;

import java.util.*;

public class MemberContainer {
    private List<Member> members;

    public MemberContainer() {
        members = new ArrayList<>();
    }

    public void addMember(String name, String city, String country) {
        String mid = MemberIdGenerator.getMemberId();
        Member member = new Member(mid, name, city, country);
        members.add(member);
        System.out.println("Member added successfully with ID: " + mid);
    }

    public void deleteMember(String id) {
        Member toRemove = null;
        for (Member m : members) {
            if (m.getMid().equalsIgnoreCase(id)) {
                toRemove = m;
                break;
            }
        }
        if (toRemove != null) {
            members.remove(toRemove);
            System.out.println("Member removed successfully.");
        } else {
            System.out.println("Member not found with given id.");
        }
    }

    public void searchById(String id) {
        if (members.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        for (Member m : members) {
            if (m.getMid().equalsIgnoreCase(id)) {
                m.display();
                return;
            }
        }
        System.out.println("Sorry! No member found.");
    }

    public void searchMember(String id, String name) {
        if (members.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        for (Member m : members) {
            if (m.getMid().equalsIgnoreCase(id) || m.getName().equalsIgnoreCase(name)) {
                m.display();
                return;
            }
        }
        System.out.println("Sorry! No member found.");
    }

    public void displaySortingOrder(String order) {
        if (members.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Comparator<Member> comparator = Comparator.comparing(Member::getName, String.CASE_INSENSITIVE_ORDER);
        if (order.equalsIgnoreCase("Desc")) {
            comparator = comparator.reversed();
        }
        members.stream().sorted(comparator).forEach(Member::display);
    }
}

