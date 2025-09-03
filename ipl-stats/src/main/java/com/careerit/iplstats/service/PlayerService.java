package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.PlayerDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerService {

    // Create
    PlayerDto addPlayer(PlayerDto playerDto);
    
    // Read
    List<PlayerDto> getAllPlayers();
    Optional<PlayerDto> getPlayerById(UUID id);
    List<PlayerDto> getPlayersByTeam(String team);
    List<PlayerDto> getPlayersByRole(String role);
    List<PlayerDto> getPlayersByCountry(String country);
    
    // Update
    PlayerDto updatePlayer(PlayerDto playerDto);
    PlayerDto updatePlayerById(UUID id, PlayerDto playerDto);
    
    // Delete
    boolean deletePlayer(UUID id);
    boolean deletePlayer(PlayerDto playerDto);
    void deleteAllPlayers();
    
    // Search methods
    List<PlayerDto> searchPlayers(String searchTerm);

    // Utility methods
    long getPlayerCount();
    List<String> getAllTeams();
    List<String> getAllRoles();
    List<String> getAllCountries();
}
