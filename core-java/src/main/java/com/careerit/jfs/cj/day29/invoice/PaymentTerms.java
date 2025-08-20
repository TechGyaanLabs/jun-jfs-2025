package com.careerit.jfs.cj.day29.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentTerms {
    private int net_days;
    private double late_fee_rate;
    private int grace_period_days;
} 