package com.gabriel.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topico = "str-topic";

    public void sendMessage(String message){
        log.info("Send message {}", message);
        kafkaTemplate.send(topico, message);
        /*.addCallback(
                success -> {
                    if(success != null){
                        log.info("Send message with success {}", message);
                        log.info("Partition {}, Offset {}",
                                success.getRecordMetadata().partition(),
                                success.getRecordMetadata().offset());
                    }
                },
                error -> log.error("Error send message")
        );*/
    }
}
