package com.careerit.lsdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamStats {
    private String teamLabel;
    private String teamName;
    private Integer totalPlayers;
    private Double totalAmount;
    private Double maxAmount;
    private Double minAmount;
    private Double averageAmount;
}
