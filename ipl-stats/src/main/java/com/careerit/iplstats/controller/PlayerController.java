package com.careerit.iplstats.controller;

import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/players")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Player Management", description = "APIs for managing IPL players")
public class PlayerController {

    private final PlayerService playerService;

    // Create
    @Operation(
        summary = "Add a new player",
        description = "Creates a new IPL player with the provided details"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Player created successfully",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = PlayerDto.class),
                examples = @ExampleObject(
                    name = "Success Response",
                    value = """
                    {
                        "id": "123e4567-e89b-12d3-a456-426614174000",
                        "name": "Virat Kohli",
                        "team": "RCB",
                        "role": "Batsman",
                        "country": "India",
                        "amount": 15000000.0
                    }
                    """
                )
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid input data",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        )
    })
    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PlayerDto> addPlayer(
        @Parameter(description = "Player details to be created", required = true)
        @RequestBody PlayerDto playerDto) {
        PlayerDto savedPlayer = playerService.addPlayer(playerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    // Read - Get all players
    @Operation(
        summary = "Get all players",
        description = "Retrieves a list of all IPL players"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved all players",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = PlayerDto.class)
            )
        )
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        List<PlayerDto> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    // Read - Get player by ID
    @Operation(
        summary = "Get player by ID",
        description = "Retrieves a specific player by their unique identifier"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Player found successfully",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = PlayerDto.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Player not found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        )
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayerDto> getPlayerById(
        @Parameter(description = "Unique identifier of the player", required = true, example = "123e4567-e89b-12d3-a456-426614174000")
        @PathVariable UUID id) {
        Optional<PlayerDto> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    // Read - Get players by team
    @GetMapping("/team/{team}")
    public ResponseEntity<List<PlayerDto>> getPlayersByTeam(@PathVariable String team) {
        List<PlayerDto> players = playerService.getPlayersByTeam(team);
        return ResponseEntity.ok(players);
    }

    // Read - Get players by role
    @GetMapping("/role/{role}")
    public ResponseEntity<List<PlayerDto>> getPlayersByRole(@PathVariable String role) {
        List<PlayerDto> players = playerService.getPlayersByRole(role);
        return ResponseEntity.ok(players);
    }

    // Read - Get players by country
    @GetMapping("/country/{country}")
    public ResponseEntity<List<PlayerDto>> getPlayersByCountry(@PathVariable String country) {
        List<PlayerDto> players = playerService.getPlayersByCountry(country);
        return ResponseEntity.ok(players);
    }

    // Search
    @Operation(
        summary = "Search players",
        description = "Searches players by name, team, role, or country (case-insensitive partial match)"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Search completed successfully",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = PlayerDto.class)
            )
        )
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlayerDto>> searchPlayers(
        @Parameter(description = "Search term to match against player name, team, role, or country", required = true, example = "virat")
        @RequestParam String searchTerm) {
        List<PlayerDto> players = playerService.searchPlayers(searchTerm);
        return ResponseEntity.ok(players);
    }

    // Update
    @Operation(
        summary = "Update player",
        description = "Updates an existing player's information by ID"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Player updated successfully",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = PlayerDto.class)
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Player not found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid input data",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        )
    })
    @PutMapping(
        value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PlayerDto> updatePlayer(
        @Parameter(description = "Unique identifier of the player to update", required = true)
        @PathVariable UUID id,
        @Parameter(description = "Updated player details", required = true)
        @RequestBody PlayerDto playerDto) {
        PlayerDto updatedPlayer = playerService.updatePlayerById(id, playerDto);
        return ResponseEntity.ok(updatedPlayer);
    }

    // Delete
    @Operation(
        summary = "Delete player",
        description = "Deletes a player by their unique identifier"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "204",
            description = "Player deleted successfully"
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Player not found"
        )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(
        @Parameter(description = "Unique identifier of the player to delete", required = true)
        @PathVariable UUID id) {
        boolean deleted = playerService.deletePlayer(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Delete all players
    @DeleteMapping
    public ResponseEntity<Void> deleteAllPlayers() {
        playerService.deleteAllPlayers();
        return ResponseEntity.noContent().build();
    }

    // Utility endpoints
    @GetMapping("/count")
    public ResponseEntity<Long> getPlayerCount() {
        long count = playerService.getPlayerCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/teams")
    public ResponseEntity<List<String>> getAllTeams() {
        List<String> teams = playerService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<String>> getAllRoles() {
        List<String> roles = playerService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/countries")
    public ResponseEntity<List<String>> getAllCountries() {
        List<String> countries = playerService.getAllCountries();
        return ResponseEntity.ok(countries);
    }
}
