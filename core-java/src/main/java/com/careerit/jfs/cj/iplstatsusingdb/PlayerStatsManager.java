package com.careerit.jfs.cj.iplstatsusingdb;

import com.careerit.jfs.cj.iplstatsusingdb.dao.PlayerStatsDao;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TeamStatsDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TopPlayerDto;

import java.util.List;

public class PlayerStatsManager {

    public static void main(String[] args) {

        PlayerStatsDao dao = new PlayerStatsDao.PlayerStatsDaoImpl();
        // 1. Team Stats
        List<TeamStatsDto> teamStats = dao.getTeamStatistics();

        System.out.println("Team Stats");
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
        List<TopPlayerDto> topPlayers = dao.getTop5HighestAmountPaidPlayers();



        // 3. Top 2 highest paid players from each team


        // 4. Players above team average


        // 5. Players by country


    }
}
