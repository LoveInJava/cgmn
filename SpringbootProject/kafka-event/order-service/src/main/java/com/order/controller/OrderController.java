package com.order.controller;

import com.domain.dto.Order;
import com.domain.dto.OrderEvent;
import com.order.kafka.OrderProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {

        log.info("Order Controller placeOrder() invoked");
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setMessage("Order status is in pending state");
        orderEvent.setStatus("PENDING");

        orderProducer.sendMessage(orderEvent);

        return "Place order request successfully";
    }
}
