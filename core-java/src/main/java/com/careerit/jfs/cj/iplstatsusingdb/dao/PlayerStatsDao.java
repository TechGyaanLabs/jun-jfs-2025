package com.careerit.jfs.cj.iplstatsusingdb.dao;

import com.careerit.jfs.cj.iplstatsusingdb.domain.Player;
import com.careerit.jfs.cj.iplstatsusingdb.dto.AboveAveragePlayerDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TeamStatsDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TopPlayerDto;

import java.util.List;

public interface PlayerStatsDao {
    
    /**
     * Get team statistics including max, min, count, average, and total amount
     * @return List of team statistics
     */
    List<TeamStatsDto> getTeamStatistics();
    
    /**
     * Get top 5 highest paid players across all teams
     * @return List of top 5 players with ranking
     */
    List<TopPlayerDto> getTop5HighestAmountPaidPlayers();
    
    /**
     * Get top 2 highest paid players from each team
     * @return List of top 2 players from each team
     */
    List<TopPlayerDto> getTop2HighestAmountPaidPlayersEachTeam();
    
    /**
     * Get players whose price is above the average price of their team
     * @return List of players above team average
     */
    List<AboveAveragePlayerDto> getPlayersAboveTeamAverage();
    
    /**
     * Get all players from a specific country
     * @param country Country name
     * @return List of players from the specified country
     */
    List<Player> getPlayersByCountry(String country);


    class PlayerStatsDaoImpl implements PlayerStatsDao {
        @Override
        public List<TeamStatsDto> getTeamStatistics() {
            return List.of();
        }

        @Override
        public List<TopPlayerDto> getTop5HighestAmountPaidPlayers() {
            return List.of();
        }

        @Override
        public List<TopPlayerDto> getTop2HighestAmountPaidPlayersEachTeam() {
            return List.of();
        }

        @Override
        public List<AboveAveragePlayerDto> getPlayersAboveTeamAverage() {
            return List.of();
        }

        @Override
        public List<Player> getPlayersByCountry(String country) {
            return List.of();
        }
    }
}
