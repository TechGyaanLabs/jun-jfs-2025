package com.careerit.jfs.cj.members;

public class MemberIdGenerator {
    private static int count = 5005;
    public String suffix = "IND";
    public String prifix = "ASHO";

    public static String getMemberId() {
        count++;
        return "ASHO" + count + "IND";
    }
}

