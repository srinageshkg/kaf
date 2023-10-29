package com.dcp.kaf.util;

import com.dcp.kaf.message.DispatchPreparing;
import com.dcp.kaf.message.OrderCreated;
import com.dcp.kaf.message.OrderDispatched;

import java.util.UUID;

public class TestEventData {
    public static OrderCreated buildOrderCreatedEvent(UUID orderId, String item) {
        return OrderCreated.builder()
                .orderId(orderId)
                .item(item)
                .build();
    }

    public static OrderDispatched buildOrderDispatchedEvent(UUID orderId) {
        return OrderDispatched.builder()
                .orderId(orderId)
                .build();
    }
    public static DispatchPreparing buildDispatchPreparingEvent(UUID orderId) {
        return DispatchPreparing.builder()
                .orderId(orderId)
                .build();
    }
}
