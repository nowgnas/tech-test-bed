package com.example.circuit.domain.channel.service;

import com.example.circuit.domain.channel.infrastructure.client.ChannelClientService;
import com.example.circuit.domain.channel.model.ClientApiResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientRequestService {

    private final ChannelClientService channelClientService;

    public ClientApiResponseModel test() {
        return channelClientService.getApiClientResponse();
    }
}
