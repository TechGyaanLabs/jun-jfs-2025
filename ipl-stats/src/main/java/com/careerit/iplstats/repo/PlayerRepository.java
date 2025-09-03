package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
    
    // Find players by team
    List<Player> findByTeam(String team);
    
    // Find players by role
    List<Player> findByRole(String role);
    
    // Find players by country
    List<Player> findByCountry(String country);
    
    // Find players by team and role
    List<Player> findByTeamAndRole(String team, String role);
    
    // Find players by country and role
    List<Player> findByCountryAndRole(String country, String role);
    
    // Find players by team and country
    List<Player> findByTeamAndCountry(String team, String country);
    
    // Find players by amount range
    List<Player> findByAmountBetween(double minAmount, double maxAmount);
    
    // Search players by name (case insensitive)
    List<Player> findByNameContainingIgnoreCase(String name);
    
    // Search players by team (case insensitive)
    List<Player> findByTeamContainingIgnoreCase(String team);
    
    // Search players by role (case insensitive)
    List<Player> findByRoleContainingIgnoreCase(String role);
    
    // Search players by country (case insensitive)
    List<Player> findByCountryContainingIgnoreCase(String country);
    
    // General search across multiple fields
    @Query("SELECT p FROM Player p WHERE " +
           "LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(p.team) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(p.role) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(p.country) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Player> searchPlayers(@Param("searchTerm") String searchTerm);
    
    // Get distinct teams
    @Query("SELECT DISTINCT p.team FROM Player p ORDER BY p.team")
    List<String> findDistinctTeams();
    
    // Get distinct roles
    @Query("SELECT DISTINCT p.role FROM Player p ORDER BY p.role")
    List<String> findDistinctRoles();
    
    // Get distinct countries
    @Query("SELECT DISTINCT p.country FROM Player p ORDER BY p.country")
    List<String> findDistinctCountries();
}
