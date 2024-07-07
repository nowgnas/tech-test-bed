package com.example.circuit.domain.channel.service;

import com.example.circuit.domain.channel.infrastructure.client.NotificationClientService;
import com.example.circuit.domain.channel.model.ClientApiResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientRequestService {

    private final NotificationClientService channelClientService;

    public ClientApiResponseModel test() {
        return channelClientService.getApiClientResponse();
    }

    public ClientApiResponseModel testDelay() {
        return channelClientService.getApiClientDelayResponse();
    }

    public ClientApiResponseModel paramsApiCall(String memberNo) {
        return channelClientService.paramApi(memberNo);
    }
}
