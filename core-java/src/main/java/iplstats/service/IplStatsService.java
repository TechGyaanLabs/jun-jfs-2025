package iplstats.service;

import iplstats.domain.Player;
import iplstats.dto.IplStatsDto;
import iplstats.dto.TeamStatsDto;

import java.util.List;

public interface IplStatsService {

        List<String> getTeamNames();
        TeamStatsDto getTeamStats(String teamName);
        IplStatsDto getIplStats();
        List<Player> getTop5PaidPlayers();
}
