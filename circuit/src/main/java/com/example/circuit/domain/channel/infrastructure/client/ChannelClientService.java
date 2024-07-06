package com.example.circuit.domain.channel.infrastructure.client;

import com.example.circuit.domain.channel.model.ClientApiResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "channelClientService", url = "${endpoint.url}")
public interface ChannelClientService {

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/channel/test/api")
    ClientApiResponseModel getApiClientResponse();

}
