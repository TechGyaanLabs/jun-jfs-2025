package com.careerit.lsdata.repo;

import com.careerit.lsdata.domain.TeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface TeamDetailsRepo extends JpaRepository<TeamDetails, UUID> {

        @Query("select t from TeamDetails t  where t.teamLabel =:teamLabel")
        Optional<TeamDetails> getTeam(String teamLabel);
}
