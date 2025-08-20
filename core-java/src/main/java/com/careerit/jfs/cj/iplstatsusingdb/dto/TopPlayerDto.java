package com.careerit.jfs.cj.iplstatsusingdb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopPlayerDto {
    private UUID id;
    private String name;
    private String role;
    private String country;
    private String team;
    private double price;
    private int rank;
}
