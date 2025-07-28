package iplstats.dto;

import iplstats.domain.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TeamStatsDto {
    private long playerCount;
    private double totalAmount;
    private long countryCount;
    private double averagePrice;
    private Map<String, Long> roleCount;
    private List<Player> players;
}
