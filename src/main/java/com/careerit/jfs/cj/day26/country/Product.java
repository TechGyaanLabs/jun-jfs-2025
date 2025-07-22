package com.careerit.jfs.cj.day26.country;

import lombok.*;
import lombok.Builder.Default;

@Builder
@ToString
@Value
public class Product {
    String name;
    double price;
    String category;
    @Default
    double discount = 100;
    @Default
    boolean inStock = true;
}