package HomeWork;

import java.util.*;

class Player {
    String name,email,city,state;
    int age;

    public Player(String name,String email, String city, String state, int age){
        this.name = name;
        this.email=email;
        this.city=city;
        this.state=state;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + " (" + city + "," + state + ")";

    }
}

class SportsClub {

    public List<String> getPlayers(List<Player> football, List<Player> cricket) {
        Set<String> footballNames = new HashSet<>();
        Set<String> bothGames = new HashSet<>();

        for(Player p : football) {
            footballNames.add(p.getName());
        }

        for(Player p : cricket) {
            if(footballNames.contains(p.getName())){
                bothGames.add(p.getName());
            }
        }


        List<String> sortedList = new ArrayList<>(bothGames);
        Collections.sort(sortedList);

        return sortedList;
    }
}