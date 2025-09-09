package com.careerit.lsdata.repo;

import com.careerit.lsdata.domain.PlayerDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PlayerDetailsRepo extends JpaRepository<PlayerDetails, UUID> {

    //Add query to use like operator

    @Query("SELECT p FROM PlayerDetails p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<PlayerDetails> findAll(Pageable pageable, String searchTerm);
}
