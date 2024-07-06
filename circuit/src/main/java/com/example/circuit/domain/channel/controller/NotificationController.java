package com.example.circuit.domain.channel.controller;

import com.example.circuit.domain.channel.model.ClientApiResponseModel;
import com.example.circuit.domain.channel.model.ListItem;
import com.example.circuit.domain.channel.service.ClientRequestService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/channel")
public class NotificationController {

    private final ClientRequestService clientRequestService;

    @GetMapping("/test/api")
    public ClientApiResponseModel test() throws InterruptedException {
        Thread.sleep(3000);
        return ClientApiResponseModel.builder()
                .data(List.of(ListItem.builder()
                        .code("200")
                        .id("ID")
                        .build()))
                .resultCode("500")
                .build();
    }

    @GetMapping("/test/api/delay")
    public ClientApiResponseModel testDelay() throws InterruptedException {
        Thread.sleep(4000);
        return ClientApiResponseModel.builder()
                .data(List.of(ListItem.builder()
                        .code("200")
                        .id("ID")
                        .build()))
                .resultCode("500")
                .build();
    }

    @GetMapping("/api/call/test")
    public ClientApiResponseModel apiTest() {
        return clientRequestService.test();
    }

    @GetMapping("/api/call/test/delay")
    public ClientApiResponseModel apiTestDelay() {
        return clientRequestService.testDelay();
    }
}
