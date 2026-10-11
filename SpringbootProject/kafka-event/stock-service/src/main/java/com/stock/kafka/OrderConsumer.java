package com.stock.kafka;

import com.domain.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener( topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrder(OrderEvent orderEvent) {

        log.info("Received Order Event: {}", orderEvent.toString());

        // Perform processing logic here

    }

}
