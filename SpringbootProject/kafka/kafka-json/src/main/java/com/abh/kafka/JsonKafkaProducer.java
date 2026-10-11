package com.abh.kafka;

import com.abh.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Employee> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Employee employee){

        logger.info("Message Sent -> {}", employee.toString());

        Message<Employee> message = org.springframework.messaging.support.MessageBuilder
                .withPayload(employee)
                .setHeader(KafkaHeaders.TOPIC, "tutorial-json-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
