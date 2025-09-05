package com.careerit.lsdata.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "team_details")
@Getter
@Setter
public class TeamDetails extends BaseEntity {

    @Column(name="team_name", nullable = false, unique = true)
    private String teamName;
    @Column(name="city", nullable = false, unique = false)
    private String city;
    @Column(name = "team_label", nullable = false, unique = true)
    private String teamLabel;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "team")
    private List<PlayerDetails> players;

}
