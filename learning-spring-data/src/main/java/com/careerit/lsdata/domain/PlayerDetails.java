package com.careerit.lsdata.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player_details")
@Getter
@Setter
public class PlayerDetails extends BaseEntity {

    private String name;
    private String role;
    private double amount;
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamDetails team;
}
