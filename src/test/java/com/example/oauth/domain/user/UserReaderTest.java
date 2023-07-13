package com.example.oauth.domain.user;

import com.example.oauth.core.exception.NotFoundException;
import com.example.oauth.infra.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserReaderTest {

    @Autowired
    private UserReader userReader;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
    }

    @Test
    public void testGetOne_fail_emptyUser() {

        //given

        final String msg = "Data Not Found";

        final Long findId = 10000L;

        //given

        NotFoundException e = assertThrows(NotFoundException.class, () -> {
            userReader.getOne(findId);
        });

        assertEquals(e.getMessage(), msg);
    }

    @Test
    @Transactional
    public void testGetOne_Ok() {

        // given
        final String email = "test@daum.net";

        final String password = "1234";

        User mock = User.of(email, password);

        userRepository.save(mock);

        // when
        User entity = userReader.getOne(mock.getId());

        // then
        assertEquals(entity, mock);
        assertEquals(entity.getEmail(), mock.getEmail());
        assertEquals(entity.getPassword(), mock.getPassword());
    }
}
