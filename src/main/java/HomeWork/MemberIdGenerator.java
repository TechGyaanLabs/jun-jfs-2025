package HomeWork;

import java.util.*;

// Generates Member IDs like "ASHO5006IND"
class MemberIdGenerator {
    private static int count = 5005;
    public static String suffix = "IND";
    public static String prefix = "ASHO";

    public static String getMemberId() {
        count++; // increment counter
        return prefix + count + suffix;
    }
}


class Member {
    private String mid;
    private String name;
    private String city;
    private String country;

    public Member(String mid, String name, String city, String country) {
        this.mid = mid;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getMid() {
        return mid;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("ID: " + mid);
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Country: " + country);
    }
}

// Container for all members
class MemberContainer {
    private List<Member> members = new ArrayList<>();

    // Add new member
    public void addMember(String name, String city, String country) {
        String mid = MemberIdGenerator.getMemberId();
        Member m = new Member(mid, name, city, country);
        members.add(m);
        System.out.println("Member added with ID: " + mid);
    }

    // Delete member by ID
    public void deleteMember(String id) {
        Iterator<Member> itr = members.iterator();
        boolean found = false;
        while (itr.hasNext()) {
            Member m = itr.next();
            if (m.getMid().equalsIgnoreCase(id)) {
                itr.remove();
                found = true;
                System.out.println("Member with ID " + id + " deleted.");
                break;
            }
        }
        if (!found) {
            System.out.println("Member not found with given ID.");
        }
    }

    // Search by ID
    public void searchById(String id) {
        if (members.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        boolean found = false;
        for (Member m : members) {
            if (m.getMid().equalsIgnoreCase(id)) {
                m.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Sorry! No member found.");
        }
    }

    // Search by ID or Name
    public void searchMember(String id, String name) {
        if (members.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        boolean found = false;
        for (Member m : members) {
            if (m.getMid().equalsIgnoreCase(id) || m.getName().equalsIgnoreCase(name)) {
                m.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry! No member found.");
        }
    }

    // Display in sorting order
    public void displaySortingOrder(String order) {
        if (members.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        List<Member> sortedList = new ArrayList<>(members);
        sortedList.sort(Comparator.comparing(Member::getName));

        if (order.equalsIgnoreCase("Desc")) {
            Collections.reverse(sortedList);
        }

        for (Member m : sortedList) {
            m.display();
            System.out.println("--------------------");
        }
    }
}

