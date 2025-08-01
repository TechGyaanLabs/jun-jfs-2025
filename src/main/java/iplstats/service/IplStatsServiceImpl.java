package iplstats.service;

import iplstats.domain.Player;
import iplstats.dto.IplStatsDto;
import iplstats.dto.TeamStatsDto;
import iplstats.util.JsonReaderUtil;

import java.util.Comparator;
import java.util.LinkedHashMap;
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
                .collect(Collectors.toList());
    }

    @Override
    public TeamStatsDto getTeamStats(String teamName) {
        List<Player> teamPlayers = players.stream()
                .filter(player -> player.getTeam().equals(teamName))
                .toList();
        long playerCount = teamPlayers.size();
        double totalAmount = teamPlayers.stream()
                .mapToDouble(Player::getPrice)
                .sum();


        long countryCount = teamPlayers.stream()
                .map(Player::getCountry)
                .distinct()
                .count();

        double averagePrice = totalAmount / playerCount;

        Map<String, Long> roleCount = teamPlayers.stream()
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
        double totalAmount = players.stream()
                .mapToDouble(Player::getPrice)
                .sum();

        long playerCount = players.size();

        // Top 3 countries by player count
        Map<String, Long> countryCount = players.stream()
                .collect(Collectors.groupingBy(Player::getCountry, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        // Top 3 roles by player count
        Map<String, Long> roleCount = players.stream()
                .collect(Collectors.groupingBy(Player::getRole, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        IplStatsDto dto = new IplStatsDto();
        dto.setTotalAmount(totalAmount);
        dto.setPlayerCount(playerCount);
        dto.setCountryCount(countryCount);
        dto.setRoleCount(roleCount);

        return dto;
    }

    @Override
    public List<Player> getTop5PaidPlayers() {
        return players.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .limit(5)
                .toList();
    }
}
