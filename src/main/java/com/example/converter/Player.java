package com.example.converter;

public class Player {
    private String name;
    private String role;
    private String country;
    private String team;
    private double price;

    // No-arg constructor
    public Player() {
    }

    // Constructor with all fields
    public Player(String name, String role, String country, String team, double price) {
        this.name = name;
        this.role = role;
        this.country = country;
        this.team = team;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getCountry() {
        return country;
    }

    public String getTeam() {
        return team;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", country='" + country + '\'' +
                ", team='" + team + '\'' +
                ", price=" + price +
                '}';
    }
} 