package com.example.oauth.domain.user;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.oauth.infra.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserReaderTest {

    private UserReader userReader;

    @Mock
    private UserRepository repository;

    @BeforeEach
    public void init() {
        this.userReader = new UserReader(repository);
    }

    @Test
    public void testGetOne_fail_emptyUser() {

        String msg = "User Not Found";

        final Long userId = 1000L;

        // given
        Mockito.when(repository.findById(anyLong())).thenReturn(Optional.empty());

        // when
        RuntimeException e = Assertions.assertThrows(RuntimeException.class, () -> userReader.getOne(userId));

        Assertions.assertEquals(msg, e.getMessage());
    }

    @Test
    public void testGetOne_Ok() {

        // given
        final Long userId = 1000L;

        final String email = "test@daum.net";

        final String password = "1234";

        User mock = User.of(email, password);

        Mockito.when(repository.findById(anyLong())).thenReturn(Optional.of(mock));

        // when
        User user = userReader.getOne(userId);

        // then
        Mockito.verify(repository, times(1)).findById(anyLong());

        Assertions.assertEquals(mock, user);
    }
}
