package com.careerit.jfs.cj.players;
import java.util.*;

public class Player {
    String name;
    String email;
    String city;
    String state;
    int age;

    public Player(String name, String email, String city, String state, int age) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.state = state;
        this.age = age;
    }
}

class SportsClub {

    public List<String> getPlayers(List<Player> football, List<Player> cricket) {
        // Store football player names (lowercased for case-insensitive comparison)
        Set<String> footballNames = new HashSet<>();
        for (Player p : football) {
            footballNames.add(p.name.toLowerCase());
        }

        // Find common names
        Set<String> common = new HashSet<>();
        for (Player p : cricket) {
            if (footballNames.contains(p.name.toLowerCase())) {
                common.add(p.name); // Keep original case for output
            }
        }

        // Convert to list and sort
        List<String> commonPlayers = new ArrayList<>(common);
        Collections.sort(commonPlayers);
        return commonPlayers;
    }

    public static void main(String[] args) {
        List<Player> football = Arrays.asList(
                new Player("Amrutha", "amrutha@mail.com", "Tenali", "AP", 25),
                new Player("Anjana", "anjana@mail.com", "Banglore", "Karnataka", 23),
                new Player("Anusha", "anusha@mail.com", "Guntur", "AP", 27)
        );

        List<Player> cricket = Arrays.asList(
                new Player("Amrutha", "amrutha@mail.com", "Tenali", "AP", 22),
                new Player("Anjana", "anjana@mail.com", "Banglore", "Karnataka", 23),
                new Player("Maheesh", "maheesh@mail.com", "Vijayawada", "AP", 25)
        );

        SportsClub club = new SportsClub();
        List<String> both = club.getPlayers(football, cricket);

        System.out.println("Players in both games: " + both);
    }
}






