package com.wsousa.aws.lambda;

import com.wsousa.aws.lambda.domain.Order;
import com.wsousa.aws.lambda.respository.OrderDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringbootAwsLambdaApplication implements ApplicationContextInitializer<GenericApplicationContext> {


    private OrderDao orderDao;

    public SpringbootAwsLambdaApplication() {
        this.orderDao = new OrderDao();
    }

    public Function<String , List<Order>> function() {
        return (input) -> orderDao.buildOrders().stream().filter(order -> order.getType().equals(input)).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
    }

    @Override
    public void initialize(GenericApplicationContext applicationContext) {
        applicationContext.registerBean("function", FunctionRegistration.class,
                () -> new FunctionRegistration<Function<String, List<Order>>>(function())
                        .type(FunctionType.from(String.class).to(List.class).getType()));
    }
}
