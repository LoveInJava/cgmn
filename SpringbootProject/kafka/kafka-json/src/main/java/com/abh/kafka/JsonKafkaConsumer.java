package com.abh.kafka;

import com.abh.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "tutorial-json-topic", groupId = "abh-group")
    public void consume(Employee employee){
        logger.info("Json Message Consume -> {}", employee.toString());
    }

}
