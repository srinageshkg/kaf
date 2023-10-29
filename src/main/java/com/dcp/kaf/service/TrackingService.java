package com.dcp.kaf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackingService {
    private static final String ORDER_TRACKING_TOPIC ="dispatch.tracking"; //"tracking.status";
    //private final KafkaTemplate<String, Object>
}
