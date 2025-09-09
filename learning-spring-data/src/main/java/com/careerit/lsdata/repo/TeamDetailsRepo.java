package com.careerit.lsdata.repo;

import com.careerit.lsdata.domain.TeamDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface TeamDetailsRepo extends JpaRepository<TeamDetails, UUID> {

        @Query("select t from TeamDetails t  where t.teamLabel =:teamLabel")
        Optional<TeamDetails> getTeam(String teamLabel);

        @Query("SELECT p FROM TeamDetails p WHERE LOWER(p.teamName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
        Page<TeamDetails> getTeamDetailsWithSearchTerm(Pageable pageable, String searchTerm);

//        @Query("SELECT new com.careerit.lsdata.dto.TeamStats(t.teamLabel, t.teamName, COUNT(p.id), SUM(p.amount), MAX(p.amount), MIN(p.amount),AVG(p.amount)) " +
//               "FROM TeamDetails t LEFT JOIN t.players p GROUP BY t.id, t.teamLabel, t.teamName")
//        List<TeamStats> getTeamStats();

}
