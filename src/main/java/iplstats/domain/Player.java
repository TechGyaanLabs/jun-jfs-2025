package iplstats.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private String team;
    private String role;
    private String country;
    private double price;
}
