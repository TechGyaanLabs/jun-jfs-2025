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
        List<TeamStatsDto> teamStats = dao.getTeamStatistics();
        System.out.println("===== Team Stats =====");
        for (TeamStatsDto teamStat : teamStats) {
            System.out.println("Team Name     : " + teamStat.getTeam());
            System.out.println("Total Players : " + teamStat.getCount());
            System.out.println("Total Amount  : " + teamStat.getTotalAmount());
            System.out.println("Average Price : " + teamStat.getAvgPrice());
            System.out.println("Max Price     : " + teamStat.getMaxPrice());
            System.out.println("Min Price     : " + teamStat.getMinPrice());
            System.out.println("----------------------------------");
        }

        // 2. Top 5 highest paid players
        List<TopPlayerDto> topPlayers = dao.getTop5HighestAmountPaidPlayers();
        System.out.println("\n===== Top 5 Highest Paid Players =====");
        for (TopPlayerDto player : topPlayers) {
            System.out.println("Rank " + player.getRank() + " - " + player.getName() +
                    " (" + player.getTeam() + ") - " + player.getPrice());
        }

        // 3. Top 2 highest paid players from each team
        List<TopPlayerDto> top2EachTeam = dao.getTop2HighestAmountPaidPlayersEachTeam();
        System.out.println("\n===== Top 2 Highest Paid Players of Each Team =====");
        for (TopPlayerDto player : top2EachTeam) {
            System.out.println("Team: " + player.getTeam() +
                    " | Rank: " + player.getRank() +
                    " | " + player.getName() +
                    " - " + player.getPrice());
        }

        // 4. Players above team average
        List<AboveAveragePlayerDto> aboveAvgPlayers = dao.getPlayersAboveTeamAverage();
        System.out.println("\n===== Players Above Team Average =====");
        for (AboveAveragePlayerDto player : aboveAvgPlayers) {
            System.out.println(player.getName() + " (" + player.getTeam() + ") - " +
                    "Price: " + player.getPrice() +
                    " | Team Avg: " + player.getTeamAveragePrice() +
                    " | Difference: " + player.getDifferenceFromAverage());
        }

        // 5. Players by country (example: India)
        String country = "India";
        List<Player> indianPlayers = dao.getPlayersByCountry(country);
        System.out.println("\n===== Players from " + country + " =====");
        for (Player player : indianPlayers) {
            System.out.println(player.getName() + " - " + player.getTeam() + " - " + player.getPrice());
        }
    }
}
