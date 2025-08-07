package iplstats.service;

import iplstats.domain.Player;
import iplstats.dto.IplStatsDto;
import iplstats.dto.TeamStatsDto;
import iplstats.util.JsonReaderUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IplStatsServiceImpl implements IplStatsService {

    private final List<Player> players = JsonReaderUtil.getPlayers();

    @Override
    public List<String> getTeamNames() {
        return players.stream()
                .map(Player::getTeam)
                .distinct()
                .toList();
    }

    @Override
    public TeamStatsDto getTeamStats(String teamName) {
        List<Player> teamPlayers = players.stream()
                .filter(player -> player.getTeam().equals(teamName))
                .toList();

        double totalAmount = teamPlayers.stream()
                .mapToDouble(Player::getPrice)
                .sum();

        long playerCount = teamPlayers.size();
        long countryCount = teamPlayers.stream()
                .map(Player::getCountry)
                .distinct()
                .count();
        double averagePrice = totalAmount / playerCount;

        Map<String,Long> roleCount = teamPlayers.stream()
                .collect(Collectors.groupingBy(Player::getRole, Collectors.counting()));
        TeamStatsDto teamStatsDto = new TeamStatsDto();
        teamStatsDto.setPlayerCount(playerCount);
        teamStatsDto.setTotalAmount(totalAmount);
        teamStatsDto.setCountryCount(countryCount);
        teamStatsDto.setAveragePrice(averagePrice);
        teamStatsDto.setPlayers(teamPlayers);
        teamStatsDto.setRoleCount(roleCount);
        return teamStatsDto;
    }

    @Override
    public IplStatsDto getIplStats() {
        return null;
    }

    @Override
    public List<Player> getTop5PaidPlayers() {
        return List.of();
    }
}
