package com.careerit.jfs.cj.iplstatsusingdb.dao;

import com.careerit.jfs.cj.iplstatsusingdb.domain.Player;
import com.careerit.jfs.cj.iplstatsusingdb.dto.AboveAveragePlayerDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TeamStatsDto;
import com.careerit.jfs.cj.iplstatsusingdb.dto.TopPlayerDto;
import com.careerit.jfs.cj.iplstatsusingdb.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerStatsDaoImpl implements PlayerStatsDao {

    @Override
    public List<TeamStatsDto> getTeamStatistics() {
        String sql = "SELECT team, COUNT(*) as count, MAX(price) as max_price, MIN(price) as min_price, " +
                "AVG(price) as avg_price, SUM(price) as total_price " +
                "FROM players GROUP BY team";

        List<TeamStatsDto> list = new ArrayList<>();
        try (Connection con = DatabaseUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                TeamStatsDto dto = new TeamStatsDto(
                        rs.getString("team"),
                        rs.getInt("count"),
                        rs.getDouble("max_price"),
                        rs.getLong("min_price"),
                        rs.getDouble("avg_price"),
                        rs.getDouble("total_price")
                );
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TopPlayerDto> getTop5HighestAmountPaidPlayers() {
        String sql = "SELECT id, name, role, country, team, price " +
                "FROM players ORDER BY price DESC LIMIT 5";
        List<TopPlayerDto> list = new ArrayList<>();
        try (Connection con = DatabaseUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            int rank = 1;
            while (rs.next()) {
                TopPlayerDto dto = new TopPlayerDto(
                        (java.util.UUID) rs.getObject("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("country"),
                        rs.getString("team"),
                        rs.getDouble("price"),
                        rank++
                );
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TopPlayerDto> getTop2HighestAmountPaidPlayersEachTeam() {
        String sql = """
                SELECT id, name, role, country, team, price, rnk
                FROM (
                    SELECT id, name, role, country, team, price,
                           ROW_NUMBER() OVER (PARTITION BY team ORDER BY price DESC) AS rnk
                    FROM players
                ) sub
                WHERE rnk <= 2
                """;

        List<TopPlayerDto> list = new ArrayList<>();
        try (Connection con = DatabaseUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                TopPlayerDto dto = new TopPlayerDto(
                        (java.util.UUID) rs.getObject("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("country"),
                        rs.getString("team"),
                        rs.getDouble("price"),
                        rs.getInt("rnk")
                );
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<AboveAveragePlayerDto> getPlayersAboveTeamAverage() {
        String sql = """
                SELECT p.id, p.name, p.role, p.country, p.team, p.price,
                       t.avg_price AS teamAveragePrice,
                       (p.price - t.avg_price) AS differenceFromAverage
                FROM players p
                JOIN (
                    SELECT team, AVG(price) AS avg_price
                    FROM players
                    GROUP BY team
                ) t ON p.team = t.team
                WHERE p.price > t.avg_price
                """;

        List<AboveAveragePlayerDto> list = new ArrayList<>();
        try (Connection con = DatabaseUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                AboveAveragePlayerDto dto = new AboveAveragePlayerDto(
                        (java.util.UUID) rs.getObject("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("country"),
                        rs.getString("team"),
                        rs.getDouble("price"),
                        rs.getDouble("teamAveragePrice"),
                        rs.getDouble("differenceFromAverage")
                );
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Player> getPlayersByCountry(String country) {
        String sql = "SELECT id, name, role, country, team, price FROM players WHERE country = ?";
        List<Player> list = new ArrayList<>();
        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, country);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Player player = new Player(
                        (java.util.UUID) rs.getObject("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("country"),
                        rs.getString("team"),
                        rs.getDouble("price")
                );
                list.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
