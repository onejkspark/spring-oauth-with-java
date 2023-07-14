package com.example.oauth.infra.oauth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

/**
 * 이 인터페이스의 구현은 요청 간의 지속성을 담당합니다 OAuth2AuthorizationRequest.
 * OAuth2AuthorizationRequestRedirectFilter인증 코드 부여 흐름을 시작하기 전에 인증 요청을 유지하기 위해 에서 사용합니다 . 또한 OAuth2LoginAuthenticationFilter권한 부여 응답의 콜백을 처리할 때 관련 권한 부여 요청을 해결하기 위해 에서 사용합니다.
 */
@Component
public class CustomAuthorizationRequestRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {

    /**
     * OAuth2AuthorizationRequest제공된 항목에 연결된 항목 을 반환 HttpServletRequest하거나 사용할 수 없는 경우 반환합니다 null.
     *
     * @param request the {@code HttpServletRequest}
     * @return
     */
    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
        return null;
    }

    /**
     * OAuth2AuthorizationRequest제공된 HttpServletRequest및/또는 에 연결 을 유지합니다 HttpServletResponse.
     *
     * @param authorizationRequest the {@link OAuth2AuthorizationRequest}
     * @param request              the {@code HttpServletRequest}
     * @param response             the {@code HttpServletResponse}
     */
    @Override
    public void saveAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest, HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * OAuth2AuthorizationRequest제공된 항목에 연결된 항목 을 제거하고 반환하거나 HttpServletRequest사용할 HttpServletResponse수 없는 경우 반환합니다 null.
     *
     * @param request  the {@code HttpServletRequest}
     * @param response the {@code HttpServletResponse}
     * @return
     */
    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
