package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppUserRepo extends JpaRepository<AppUser, UUID> {

    List<AppUser> findByEmailContainingIgnoreCase(String s);
}
