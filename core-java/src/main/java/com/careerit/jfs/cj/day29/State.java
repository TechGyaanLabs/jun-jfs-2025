package com.careerit.jfs.cj.day29;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class State {
    private String name;
    private List<String> cities;
}
