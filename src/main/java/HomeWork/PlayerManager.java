package HomeWork;

import java.util.Arrays;
import java.util.List;

public class PlayerManager {
    public static void main(String[] args) {
        List<Player> football = Arrays.asList(
                new Player("John", "john@mail.com", "Delhi", "Delhi", 25),
                new Player("Mike", "mike@mail.com", "Mumbai", "Maharashtra", 27),
                new Player("Ravi", "ravi@mail.com", "Chennai", "Tamil Nadu", 23)
        );

        List<Player> cricket = Arrays.asList(
                new Player("Mike", "mike@mail.com", "Mumbai", "Maharashtra", 27),
                new Player("Ravi", "ravi@mail.com", "Chennai", "Tamil Nadu", 23),
                new Player("Sam", "sam@mail.com", "Kolkata", "West Bengal", 26)
        );

        SportsClub club = new SportsClub();
        List<String> commonPlayers = club.getPlayers(football, cricket);

        System.out.println("Players in both games: " + commonPlayers);

    }
}
