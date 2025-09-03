package com.careerit.iplstats.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Player information for IPL statistics")
public class PlayerDto {
    
    @Schema(
        description = "Unique identifier of the player",
        example = "123e4567-e89b-12d3-a456-426614174000",
        accessMode = Schema.AccessMode.READ_ONLY
    )
    private UUID id;
    
    @Schema(
        description = "Full name of the player",
        example = "Virat Kohli",
        required = true,
        minLength = 2,
        maxLength = 100
    )
    private String name;
    
    @Schema(
        description = "IPL team name",
        example = "RCB",
        required = true,
        maxLength = 50
    )
    private String team;
    
    @Schema(
        description = "Player role/position",
        example = "Batsman",
        required = true,
        allowableValues = {"Batsman", "Bowler", "All-rounder", "Wicket-keeper", "Wicket-keeper Batsman"}
    )
    private String role;
    
    @Schema(
        description = "Country of origin",
        example = "India",
        required = true,
        maxLength = 50
    )
    private String country;
    
    @Schema(
        description = "Player salary/amount in INR",
        example = "15000000.0",
        required = true,
        minimum = "0.0"
    )
    private double amount;
}
