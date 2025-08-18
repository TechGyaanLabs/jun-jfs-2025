package com.careerit.jfs.cj.iplstatsusingdb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamStatsDto {
    private String team;
    private double maxPrice;
    private double minPrice;
    private long count;
    private double avgPrice;
    private double totalAmount;
}
