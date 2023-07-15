package com.example.oauth.infra.oauth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CustomClientRegistrationRepositoryTest {

    @Autowired
    private CustomClientRegistrationRepository clientRegistrationRepository;

    @Test
    public void whenGivenToAppClientId_thenIsSuccess() throws Exception {
        //given
        final String findClientId = "app-client-id";
        //when
        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId(findClientId);
        //then
        assertEquals(clientRegistration.getClientId(), findClientId);
    }

    @Test
    public void whenGivenToNotClientId_thenIsNPE() throws Exception {
        //given
        final String findClientId = "not-client-id";
        //when
        NullPointerException e = assertThrows(NullPointerException.class, () -> clientRegistrationRepository.findByRegistrationId(findClientId));
        //then
        assertEquals(e.getMessage(), "clientRegistration is not null");
    }

    @Test
    public void whenGivenNull_thenIsIllegalArgumentException() throws Exception {
        //given
        final String findClientId = null;
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> clientRegistrationRepository.findByRegistrationId(findClientId));
        //then
        assertEquals(e.getMessage(), "registrationId is not null");
    }
}
