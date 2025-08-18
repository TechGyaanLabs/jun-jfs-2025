package com.careerit.jfs.cj.iplstatsusingdb.dao;

import com.careerit.jfs.cj.iplstatsusingdb.domain.Player;
import com.careerit.jfs.cj.iplstatsusingdb.dto.AboveAveragePlayerDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TeamStatsDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TopPlayerDto;

import java.util.List;

public class PlayerStatsDaoImpl implements PlayerStatsDao {
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
