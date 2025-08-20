package com.careerit.jfs.cj.iplstatsusingdb;

import com.careerit.jfs.cj.iplstatsusingdb.dto.PlayerDto;
import com.careerit.jfs.cj.iplstatsusingdb.util.DataLoaderUtil;
import com.careerit.jfs.cj.jdbc.ConnectionUtil;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.UUID;

public class StatementTypesExample {

    public static void main(String[] args) {

        insertPlayersWithPreparedStatement();

    }

    public static void showAllPlayers() {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            con = ConnectionUtil.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from players");
            while (rs.next()) {
                System.out.println(rs.getObject("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("role"));
                System.out.println(rs.getString("country"));
                System.out.println(rs.getString("team"));
                System.out.println(rs.getDouble("price"));
                System.out.println("-".repeat(100));
            }
        }catch(SQLException e) {
            System.out.println(e);
        }finally {
            ConnectionUtil.close(rs, stmt, con);
        }
    }

    public static void showPlayersAmountBetween(double min, double max) {

    }

    public static void showAllPlayers(String teamName) {

        String sql = "select * from players where team = ?";
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            con = ConnectionUtil.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, teamName);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getObject("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("role"));
                System.out.println(rs.getString("country"));
                System.out.println(rs.getString("team"));
                System.out.println(rs.getDouble("price"));
                System.out.println("-".repeat(100));
            }
        }catch(SQLException e) {
            System.out.println(e);
        }finally {
            ConnectionUtil.close(rs, stmt, con);
        }

    }


    public static void insertPlayersWithStatement() {

        DataLoaderUtil.clearTable();
        Connection con=null;
        Statement stmt=null;
        try {
            List<PlayerDto> players = DataLoaderUtil.readPlayersFromJson();
            long start = System.currentTimeMillis();
            con = ConnectionUtil.getConnection();
            stmt = con.createStatement();
            con.setAutoCommit(false);
            for (PlayerDto player : players) {
                UUID id = UUID.randomUUID();
                String sql = "insert into players(id,name,role,country,team,price) values('" + id + "','" + player.getName() + "','"
                        + player.getRole() + "','" + player.getCountry() + "','" + player.getTeam() + "','"
                        + player.getPrice() + "');";
                stmt.addBatch(sql);
            }
            int[] results = stmt.executeBatch();
            System.out.println("Total inserted: " + results.length + " players");
            con.commit();
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) + " ms");
        }catch (SQLException | IOException e){
            System.out.println(e);
        }finally {
            ConnectionUtil.close(null, stmt, con);
        }
    }

    public static void insertPlayersWithPreparedStatement() {

        DataLoaderUtil.clearTable();
        Connection con=null;
        PreparedStatement pst=null;
        try {
            List<PlayerDto> players = DataLoaderUtil.readPlayersFromJson();
            long start = System.currentTimeMillis();
            con = ConnectionUtil.getConnection();
            con.setAutoCommit(false);
            String sql = "insert into players(id,name,role,country,team,price) values(?,?,?,?,?,?)";
           pst = con.prepareStatement(sql);
            for (PlayerDto player : players) {
                UUID id = UUID.randomUUID();
                pst.setObject(1, id);
                pst.setString(2, player.getName());
                pst.setString(3, player.getRole());
                pst.setString(4, player.getCountry());
                pst.setString(5, player.getTeam());
                pst.setDouble(6, player.getPrice());
                pst.addBatch();

            }
            int[] results = pst.executeBatch();
            System.out.println("Total inserted: " + results.length + " players");
            con.commit();
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) + " ms");
        }catch (SQLException | IOException e){
            System.out.println(e);
        }finally {
            ConnectionUtil.close(null, pst, con);
        }
    }

}
