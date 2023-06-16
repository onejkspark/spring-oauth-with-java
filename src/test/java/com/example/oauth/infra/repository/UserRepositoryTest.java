package com.example.oauth.infra.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.oauth.domain.user.User;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {

    private @Autowired UserRepository userRepository;


    @Nested
    @DisplayName("저장하는 메소드는")
    public class Save {

        @Test
        @DisplayName("성공적으로 동작한다.")
        public void testSave() {

            String email = "test@naver.com";

            String password = "12345";

            User mock = User.of(email, password);

            User entity = userRepository.save(mock);

            assertEquals(mock.getId(), entity.getId());
            assertEquals(mock.getEmail(), entity.getEmail());
            assertEquals(mock.getPassword(), entity.getPassword());
        }

        @DisplayName("데이터가 비워져있다면, 실패를 하게 된다.")
        @ParameterizedTest(name = "이메일 데이터는 {0} 와 비밀번호 데이터는 {1} 이다.")
        @MethodSource("com.example.oauth.infra.repository.UserRepositoryTest#testSaveFailArgs")
        public void testSaveFail(String email, String password) {

            User mock = User.of(email, password);

            assertThrows(DataIntegrityViolationException.class, () -> userRepository.save(mock));
        }
    }

    private static Stream<Arguments> testSaveFailArgs() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("test@naver.com", null),
                Arguments.of(null, "12345")
        );
    }
}