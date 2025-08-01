package com.careerit.jfs.cj.day29.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Metadata {
    private String created_by;
    private String created_date;
    private String last_modified;
    private String version;
} 