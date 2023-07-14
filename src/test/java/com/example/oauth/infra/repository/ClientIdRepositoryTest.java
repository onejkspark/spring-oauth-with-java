package com.example.oauth.infra.repository;

import com.example.oauth.dto.ClientIdDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ClientIdRepositoryTest {

    @Autowired
    private ClientIdRepository clientIdRepository;

    @Test
    @Transactional
    public void whenGivenClientId_thenIsSuccess() throws Exception {

        //given
        final int size = 1;

        //when
        List<ClientIdDTO> entities = clientIdRepository.findByAll();

        //then
        assertNotNull(entities);
        assertEquals(entities.size(), size);
    }

    @Test
    @Transactional
    public void whenAppClientId_thenIsSuccess() throws Exception {
        //given
        final String clientId = "app-client-id";
        //when
        ClientIdDTO entity = clientIdRepository.findById(clientId);
        //then
        assertEquals(entity.getClientId(), clientId);
    }
}
