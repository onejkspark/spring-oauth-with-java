package com.example.oauth.infra.oauth;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

/**
 * OAuth2AuthorizationRequest이 인터페이스의 구현은 제공된 에서 를 해결할 수 있습니다 HttpServletRequest. 인증 요청을 해결하기 위해 에서 사용합니다 OAuth2AuthorizationRequestRedirectFilter.
 */
@Component
public class CustomOAuth2AuthorizationRequestResolver implements OAuth2AuthorizationRequestResolver {

    /**
     * OAuth2AuthorizationRequest제공된 것에서 해결된 것을 반환 HttpServletRequest하거나 사용할 수 없는 경우 반환합니다 null.
     *
     * @param request the {@code HttpServletRequest}
     * @return
     */
    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
        return null;
    }

    /**
     * OAuth2AuthorizationRequest제공된 것에서 해결된 것을 반환 HttpServletRequest하거나 사용할 수 없는 경우 반환합니다 null.
     *
     * @param request              the {@code HttpServletRequest}
     * @param clientRegistrationId the clientRegistrationId to use
     * @return
     */
    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
        return null;
    }
}
