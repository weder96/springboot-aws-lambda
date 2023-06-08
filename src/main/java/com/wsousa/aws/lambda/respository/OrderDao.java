package com.wsousa.aws.lambda.respository;

import com.wsousa.aws.lambda.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class OrderDao {

    public List<Order> buildOrders(){
        return Stream.of(
                new Order(101, "Mobile", "Xiaomi",1800, 1),
                new Order(102, "Book","Programming Aws Lambda: Build and Deploy Serverless Applications with Java", 69, 2),
                new Order(103, "Book","Spring Boot: Up and Running: Building Cloud Native Java and Kotlin Applications", 329, 3),
                new Order(104, "Jeans","blue jeans", 300, 1)
        ).collect(Collectors.toList());
    }
}
