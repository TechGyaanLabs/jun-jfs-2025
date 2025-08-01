package com.careerit.jfs.cj.day29.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Shipping {
    private String method;
    private double cost;
    private String tracking_number;
    private String estimated_delivery;
} 