package com.careerit.jfs.cj.iplstatsusingdb;

import com.careerit.jfs.cj.iplstatsusingdb.dao.PlayerStatsDao;
import com.careerit.jfs.cj.iplstatsusingdb.dao.PlayerStatsDaoImpl;
import com.careerit.jfs.cj.iplstatsusingdb.domain.Player;
import com.careerit.jfs.cj.iplstatsusingdb.dto.AboveAveragePlayerDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TeamStatsDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TopPlayerDto;

import java.util.List;

public class PlayerStatsManager {

    public static void main(String[] args) {

        PlayerStatsDao dao = new PlayerStatsDaoImpl();

        // 1. Team Stats
        System.out.println("=== Team Stats ===");
        List<TeamStatsDto> teamStats = dao.getTeamStatistics();
        for (TeamStatsDto teamStat : teamStats) {
            System.out.println("Team Name: " + teamStat.getTeam());
            System.out.println("Total Players: " + teamStat.getCount());
            System.out.println("Total Amount: " + teamStat.getTotalAmount());
            System.out.println("Average Price: " + teamStat.getAvgPrice());
            System.out.println("Max Price: " + teamStat.getMaxPrice());
            System.out.println("Min Price: " + teamStat.getMinPrice());
            System.out.println();
        }

        // 2. Top 5 highest paid players
        System.out.println("=== Top 5 Highest Paid Players ===");
        List<TopPlayerDto> topPlayers = dao.getTop5HighestAmountPaidPlayers();
        for (TopPlayerDto player : topPlayers) {
            System.out.println(player.getRank() + ". " + player.getName() + " - " + player.getTeam() +
                    " (" + player.getRole() + ", " + player.getCountry() + ") : " + player.getPrice());
        }
        System.out.println();

        // 3. Top 2 highest paid players from each team
        System.out.println("=== Top 2 Highest Paid Players from Each Team ===");
        List<TopPlayerDto> topPlayersByTeam = dao.getTop2HighestAmountPaidPlayersEachTeam();
        for (TopPlayerDto player : topPlayersByTeam) {
            System.out.println(player.getTeam() + " -> " + player.getName() + " - " + player.getPrice());
        }
        System.out.println();

        // 4. Players above team average
        System.out.println("=== Players Above Team Average ===");
        List<AboveAveragePlayerDto> playersAboveAvg = dao.getPlayersAboveTeamAverage();
        for (AboveAveragePlayerDto player : playersAboveAvg) {
            System.out.println(player.getTeam() + " -> " + player.getName() +
                    " (Price: " + player.getPrice() +
                    ", Team Avg: " + player.getTeamAveragePrice() +
                    ", Diff: " + player.getDifferenceFromAverage() + ")");
        }
        System.out.println();

        // 5. Players by country
        System.out.println("=== Players By Country (India) ===");
        List<Player> playersByCountry = dao.getPlayersByCountry("India");
        for (Player player : playersByCountry) {
            System.out.println(player.getName() + " - " + player.getTeam() + " : " + player.getPrice());
        }
    }
}
