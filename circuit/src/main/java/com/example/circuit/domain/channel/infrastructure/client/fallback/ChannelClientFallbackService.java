package com.example.circuit.domain.channel.infrastructure.client.fallback;

import com.example.circuit.domain.channel.infrastructure.client.ChannelClientService;
import com.example.circuit.domain.channel.model.ClientApiResponseModel;
import org.springframework.stereotype.Component;

@Component
public class ChannelClientFallbackService implements ChannelClientService {

    @Override
    public ClientApiResponseModel getApiClientResponse() {
        return ClientApiResponseModel.builder()
                .resultCode("ERROR")
                .build();
    }

    @Override
    public ClientApiResponseModel getApiClientDelayResponse() {
        return ClientApiResponseModel.builder()
                .resultCode("ERROR").build();
    }
}
