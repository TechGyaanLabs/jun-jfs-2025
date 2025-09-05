package com.careerit.lsdata.repo;

import com.careerit.lsdata.domain.PlayerDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlayerDetailsRepo extends CrudRepository<PlayerDetails, UUID> {
}
