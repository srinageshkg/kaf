package com.dcp.kaf.handler;

import com.dcp.kaf.message.OrderCreated;
import com.dcp.kaf.service.DispatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedHandler {

    private final DispatchService dispatchService;
    @KafkaListener(
            id="orderConsumerClient",
            topics="order.created",
            groupId="dispatch.order.created.consumer",
            containerFactory="kafkaListenerContainerFactory"
    )
    public void listen(OrderCreated payload) {
        log.info("Received the message: payload: " + payload);
        try {
            dispatchService.process(payload);
        } catch (Exception e) {
            log.error("Processing failure", e);
        }
    }
}
