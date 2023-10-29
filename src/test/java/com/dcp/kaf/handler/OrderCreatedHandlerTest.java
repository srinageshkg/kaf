package com.dcp.kaf.handler;

import com.dcp.kaf.message.OrderCreated;
import com.dcp.kaf.service.DispatchService;
import com.dcp.kaf.util.TestEventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.*;

class OrderCreatedHandlerTest {

    private OrderCreatedHandler handler;
    private OrderCreated testEventData;
    private DispatchService dispatchServiceMock;

    @BeforeEach
    void setUp() {
        dispatchServiceMock = mock(DispatchService.class);
        handler = new OrderCreatedHandler(dispatchServiceMock);
        //testEventData = TestEventData.buildOrderCreatedEvent(randomUUID(), randomUUID().toString());
    }

    @Test
    void listen_Success() throws Exception {
        OrderCreated testEvent = TestEventData.buildOrderCreatedEvent(randomUUID(), randomUUID().toString());
        handler.listen(testEvent);
        verify(dispatchServiceMock, times(1)).process(testEvent);
    }

    public void listen_ServiceThrowsException() throws Exception {
        OrderCreated testEvent = TestEventData.buildOrderCreatedEvent(randomUUID(), randomUUID().toString());
        doThrow(new RuntimeException("Service Failure")).when(dispatchServiceMock).process(testEvent);

        handler.listen(testEvent);

        verify(dispatchServiceMock, times(1)).process(testEvent);
    }
}