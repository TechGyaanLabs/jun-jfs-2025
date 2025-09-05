package com.careerit.lsdata.dto;

import lombok.Data;

@Data
public class TeamStats {
    private String teamLabel;
    private String teamName;
    private int totalPlayers;
    private double totalAmount;
    private double maxAmount;
    private double minAmount;
    private double averageAmount;
}
