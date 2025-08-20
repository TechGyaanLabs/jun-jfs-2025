package com.careerit.jfs.cj.day28;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class SortPlayers implements Comparator<Player>{

    @Override
    public int compare(Player o1, Player o2) {
       return Comparator.comparingDouble(Player::getPrice).reversed().compare(o1,o2);
    }
}

public class SetExampleWithOtherClasses {

    public static void main(String[] args) {

        InputStream playersStream = JsonReaderUtil.class
                .getClassLoader().getResourceAsStream("players.json");
        List<Player> playersSet = JsonReaderUtil.loadJson(playersStream, new TypeReference<List<Player>>() {});
        Set<Player> set = new TreeSet<>(new SortPlayers());
        set.addAll(playersSet);
        set.forEach(System.out::println);
    }
}
