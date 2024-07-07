//package com.example.circuit.domain.channel.infrastructure.client.fallback;
//
//import com.example.circuit.domain.channel.infrastructure.client.NotificationClientService;
//import com.example.circuit.domain.channel.model.ClientApiResponseModel;
//import org.springframework.stereotype.Component;
//
//@Component
//public class NotificationClientFallbackService implements NotificationClientService {
//
//    @Override
//    public ClientApiResponseModel getApiClientResponse() {
//        return ClientApiResponseModel.builder()
//                .resultCode("ERROR")
//                .build();
//    }
//
//    @Override
//    public ClientApiResponseModel getApiClientDelayResponse() {
//        return ClientApiResponseModel.builder()
//                .resultCode("ERROR").build();
//    }
//
//    @Override
//    public ClientApiResponseModel paramApi(String memberNo) {
//        return null;
//    }
//}
