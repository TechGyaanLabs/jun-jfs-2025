package com.careerit.jfs.cj.day23;

import java.util.ArrayList;
import java.util.List;

public class ListExample3 {
    public static void main(String[] args) {
        List<String> hockeyPlayers = List.of("Rahul", "Rohit", "Jadeja", "Dhoni", "Kohli");
        List<String> cricketPlayers = List.of("Dhoni", "Rohit", "Kohli", "Rahul", "Jadeja", "Ronaldo", "Lewandowski");
        List<String> footballPlayers = List.of("Jadeja", "Ronaldo", "Rahul", "Dhoni", "Lewandowski");


        // Find the common players in all 3 lists
        List<String> commonPlayers = new ArrayList<>();
        for (String name : hockeyPlayers) {
            if (cricketPlayers.contains(name) && footballPlayers.contains(name)) {
                commonPlayers.add(name);
            }
        }

        // Get all unique player names
        List<String> uniqueNames = new ArrayList<>();
        uniqueNames.addAll(hockeyPlayers);
        uniqueNames.addAll(cricketPlayers);
        uniqueNames.addAll(footballPlayers);
        uniqueNames = uniqueNames.stream().distinct().toList();

        // Get all players in cricketPlayers who are not in hockeyPlayers
        List<String> cricketPlayersOnly = new ArrayList<>();
        for (String name : cricketPlayers) {
            if (!hockeyPlayers.contains(name)) {
                cricketPlayersOnly.add(name);
            }
        }
        System.out.println("Common players in all games: " + commonPlayers);
        System.out.println("Unique names :" + uniqueNames);
        System.out.println("Only playing cricket not Hockey :" + cricketPlayersOnly);
    }
}
