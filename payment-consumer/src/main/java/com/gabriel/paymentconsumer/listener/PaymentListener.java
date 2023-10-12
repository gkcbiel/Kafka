package com.gabriel.paymentconsumer.listener;

import com.gabriel.paymentconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class PaymentListener {
    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "paymentContainerFactory")
    public void antiFraude(@Payload Payment payment){
        log.info("recebi o pagamento {}", payment.toString());
        sleep(2000);
        
        log.info("Validando fraude...");
        sleep(2000);

        log.info("Compra aprovada...");
        sleep(3000);

    }
}
