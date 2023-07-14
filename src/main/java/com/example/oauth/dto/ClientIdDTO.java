package com.example.oauth.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientIdDTO {

    private final String clientId;

    private final String clientSecret;

    public static ClientIdDTO of(String clientId, String clientSecret) {
        return new ClientIdDTO(clientId, clientSecret);
    }
}
