package com.example.circuit.domain.channel.infrastructure.client;

import com.example.circuit.domain.channel.infrastructure.client.fallback.ChannelClientFallbackService;
import com.example.circuit.domain.channel.model.ClientApiResponseModel;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "channelClientService", url = "${endpoint.url}", fallback = ChannelClientFallbackService.class)
public interface ChannelClientService {

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/channel/test/api")
    ClientApiResponseModel getApiClientResponse();

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/channel/test/api/delay")
    @CircuitBreaker(name = "getApiClientResponse", fallbackMethod = "getApiClientResponseFallback")
    ClientApiResponseModel getApiClientDelayResponse();


    default ClientApiResponseModel getApiClientResponseFallback(Throwable T) {
        return ClientApiResponseModel.builder()
                .resultCode("resilience4j ERROR")
                .build();
    }
}
