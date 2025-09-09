package com.careerit.lsdata.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDto {

    private UUID id;
    private String name;
    private String role;
    private double amount;
    private String country;
    private String teamName;
}
