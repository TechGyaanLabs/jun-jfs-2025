package com.careerit.jfs.cj.day29;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Tenant {
    private String name;
    private List<String> email;
    private String ip;
    private List<State> states;
}
