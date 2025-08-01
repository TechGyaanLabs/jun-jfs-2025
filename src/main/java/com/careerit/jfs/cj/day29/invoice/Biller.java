package com.careerit.jfs.cj.day29.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Biller {
    private String company_name;
    private String email;
    private String phone;
    private Address address;
} 