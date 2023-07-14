package com.example.oauth.infra.oauth;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Component;

/**
 * OAuth 2.0 / OpenID Connect 1.0용 저장소입니다 ClientRegistration.
 * 참고: 클라이언트 등록 정보는 궁극적으로 관련 권한 부여 서버에서 저장하고 소유합니다. 따라서 이 리포지토리는 권한 부여 서버 외부에서 기본 클라이언트 등록 정보 의 하위 집합 복사본을 저장하는 기능을 제공합니다
 */
@Component
public class CustomClientRegistrationRepository implements ClientRegistrationRepository {

    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {
        return null;
    }
}
