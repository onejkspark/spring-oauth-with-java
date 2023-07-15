package com.example.oauth.infra.oauth;

import com.example.oauth.infra.repository.ClientIdRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.springframework.util.Assert.notNull;

/**
 * OAuth 2.0 / OpenID Connect 1.0용 저장소입니다 ClientRegistration.
 * 참고: 클라이언트 등록 정보는 궁극적으로 관련 권한 부여 서버에서 저장하고 소유합니다. 따라서 이 리포지토리는 권한 부여 서버 외부에서 기본 클라이언트 등록 정보 의 하위 집합 복사본을 저장하는 기능을 제공합니다
 * InMemoryClientRegistrationRepository : 일반적으로 in memory 에 올려서 사용
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CustomClientRegistrationRepository implements ClientRegistrationRepository {

    private Map<String, ClientRegistration> clientRegistrationMap;

    private final ClientIdRepository clientIdRepository;

    @PostConstruct
    public void postConstruct() {
        clientRegistrationMap = clientIdRepository.findByAllToClientRegistrationMap();
        log.trace("success client id and size is {}", clientRegistrationMap.size());
    }

    @PreDestroy
    public void preDestroy() {
        log.trace("working to @PreDestroy");
    }

    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {

        notNull(registrationId, "registrationId is not null");

        log.trace("client id is {}", registrationId);

        var clientRegistration = clientRegistrationMap.get(registrationId);

        if (clientRegistration == null) {
            throw new NullPointerException("clientRegistration is not null");
        }

        return clientRegistration;
    }
}
