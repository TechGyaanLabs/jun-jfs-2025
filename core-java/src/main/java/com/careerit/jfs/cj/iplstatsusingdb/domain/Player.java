package com.careerit.jfs.cj.iplstatsusingdb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
    private UUID id;
    private String name;
    private String role;
    private String country;
    private String team;
    private double price;
}
