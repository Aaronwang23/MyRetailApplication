package com.example.MyRetail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Price {
    private String currentPrice;
    private String currencyCode;
}
