package com.dcp.kaf.service;

import com.dcp.kaf.message.OrderCreated;
import com.dcp.kaf.message.OrderDispatched;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DispatchService {
    private static final String ORDER_DISPATCHED_TOPIC="order.dispatched";
    private final KafkaTemplate<String, Object> kafkaProducer;
    public void process(OrderCreated orderCreated) throws Exception {
        OrderDispatched orderDispatched = OrderDispatched.builder()
                .orderId(orderCreated.getOrderId())
                .build();
        kafkaProducer.send(ORDER_DISPATCHED_TOPIC, orderDispatched).get();
    }

}
