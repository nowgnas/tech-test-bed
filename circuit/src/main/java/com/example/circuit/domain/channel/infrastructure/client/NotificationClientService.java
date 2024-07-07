package com.example.circuit.domain.channel.infrastructure.client;

import com.example.circuit.domain.channel.model.ClientApiResponseModel;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "notificationClientService", url = "${endpoint.url}")
public interface NotificationClientService {

    @GetMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/v1/channel/test/api"
    )
    ClientApiResponseModel getApiClientResponse();

    @GetMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/v1/channel/test/api/delay"
    )
    @CircuitBreaker(name = "getApiClientResponse", fallbackMethod = "getApiClientResponseFallback")
    ClientApiResponseModel getApiClientDelayResponse();


    default ClientApiResponseModel getApiClientResponseFallback(Throwable T) {
        return ClientApiResponseModel.builder()
                .resultCode("resilience4j ERROR")
                .build();
    }

    @GetMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/v1/channel/api/params",
            params = "memberNo"
    )
    ClientApiResponseModel paramApi(@RequestParam("memberNo") String memberNo);

}
