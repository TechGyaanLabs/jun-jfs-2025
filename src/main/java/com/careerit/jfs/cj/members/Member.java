package com.careerit.jfs.cj.members;

import lombok.Getter;

public class Member {
    @Getter
    String mid;
    @Getter
    String name;
    String city;
    String country;

    public Member(String mid, String name, String city, String country) {
        this.mid = mid;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public void display() {
        System.out.println(mid + " | " + name + " | " + city + " | " + country);
    }
}

