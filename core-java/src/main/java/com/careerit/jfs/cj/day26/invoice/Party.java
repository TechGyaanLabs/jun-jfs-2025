package com.careerit.jfs.cj.day26.invoice;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Party {
    private String companyName;
    private String address;
    private String phone;
    private String email;
    private String gstNumber;

}