package com.example.oauth.infra.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class OAuth2ClientSecurityConfiguration {

    private final ClientRegistrationRepository clientRegistrationRepository;

    private final OAuth2AuthorizedClientRepository authorizedClientRepository;

    private final OAuth2AuthorizedClientService authorizedClientService;

    private final AuthorizationRequestRepository<OAuth2AuthorizationRequest> authorizationRequestRepository;

    private final OAuth2AuthorizationRequestResolver authorizationRequestResolver;

    private final OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests();

        http.oauth2Login()
                .userInfoEndpoint()
                .userService(userRequest -> {
                    log.info("test 1");
                    return null;
                })
                .and()
                .successHandler((request, response, authentication) -> {
                    log.info("test 2");

                })
                .failureHandler((request, response, exception) -> {
                    log.info("test 3");
                })
                .permitAll();

        http.oauth2Client(oauth2 -> oauth2
                .clientRegistrationRepository(clientRegistrationRepository)
                .authorizedClientRepository(authorizedClientRepository)
                .authorizedClientService(authorizedClientService)
                .authorizationCodeGrant(codeGrant -> codeGrant
                        .authorizationRequestRepository(authorizationRequestRepository)
                        .authorizationRequestResolver(authorizationRequestResolver)
                        .accessTokenResponseClient(accessTokenResponseClient)
                )
        );

        return http.build();
    }

    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(OAuth2AuthorizedClientRepository authorizedClientRepository) {

        var authorizedClientProvider =
                OAuth2AuthorizedClientProviderBuilder.builder()
                        .authorizationCode()
                        .refreshToken()
                        .clientCredentials()
                        .password()
                        .build();

        var authorizedClientManager = new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository, authorizedClientRepository);

        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

        return authorizedClientManager;
    }
}
