package com.example.oauth.infra.oauth;

import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.stereotype.Component;

/**
 * 권한 부여 서버의 토큰 끝점에서 액세스 토큰 자격 증명에 대한 권한 부여 자격 증명(예: 권한 부여 코드)을 "교환"하기 위한 전략입니다
 */
@Component
public class CustomAccessTokenResponseClient implements OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> {

    /**
     * 권한 부여 요청에 제공된 권한 부여 자격 증명을 권한 부여 서버의 토큰 끝점에서 액세스 토큰 자격 증명으로 교환합니다.
     *
     * @param authorizationGrantRequest the authorization grant request that contains the
     *                                  authorization grant credential
     * @return
     */
    @Override
    public OAuth2AccessTokenResponse getTokenResponse(OAuth2AuthorizationCodeGrantRequest authorizationGrantRequest) {
        return null;
    }
}
