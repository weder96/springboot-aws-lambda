package com.wsousa.aws.lambda.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private int id;
    private String type;
    private String title;
    private double price;
    private int quantity;
}
