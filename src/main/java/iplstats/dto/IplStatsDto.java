package iplstats.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class IplStatsDto {
    private double totalAmount;
    private long playerCount;
    private Map<String, Long> countryCount; // return only top 3 rows
    private Map<String, Long> roleCount;  // return only top 3 rows

}
