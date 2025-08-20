package iplstats;

import com.fasterxml.jackson.databind.ObjectMapper;
import iplstats.domain.Player;
import iplstats.dto.IplStatsDto;
import iplstats.dto.TeamStatsDto;
import iplstats.service.IplStatsService;
import iplstats.service.IplStatsServiceImpl;

import java.util.List;
import java.util.Scanner;

public class IplStatsManager {

    public static void main(String[] args) throws Exception {

        IplStatsService iplStatsService = new IplStatsServiceImpl();

        while (true) {

            System.out.println("\nWelcome to IPL Stats");
            System.out.println("-".repeat(150));
            System.out.println("1. View Team names");
            System.out.println("2. View Team stats");
            System.out.print("Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            ObjectMapper mapper = new ObjectMapper();

            switch (choice) {
                case 1:
                    List<String> teamNames = iplStatsService.getTeamNames();
                    System.out.println("Team Names: ");
                    teamNames.forEach(t -> System.out.print(t + "\t"));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter team name: ");
                    String teamName = new Scanner(System.in).nextLine();
                    TeamStatsDto teamStatsDto = iplStatsService.getTeamStats(teamName);

                    System.out.println(mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(teamStatsDto));
                    break;
                case 3:
                    IplStatsDto iplStatsDto = iplStatsService.getIplStats();
                    System.out.println(mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(iplStatsDto));
                    break;
                case 4:
                    List<Player> top5PaidPlayers = iplStatsService.getTop5PaidPlayers();
                    System.out.println(mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(top5PaidPlayers));
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
