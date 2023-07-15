package com.example.oauth.infra.repository;

import com.example.oauth.dto.ClientIdDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ClientIdRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<ClientIdDTO> findByAll() {
        return jdbcTemplate.query("""
                                select client_id 
                                , client_secret
                                from app_client_id 
                        """,
                new RowMapper<ClientIdDTO>() {
                    @Override
                    public ClientIdDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return ClientIdDTO.of(
                                rs.getString("client_id"),
                                rs.getString("client_secret")
                        );
                    }
                });
    }

    public Map<String, ClientRegistration> findByAllToClientRegistrationMap() {

        List<ClientIdDTO> entities = findByAll();

        if (entities.isEmpty()) return new HashMap<>();

        return entities.stream()
                .map(dto ->
                        ClientRegistration.withRegistrationId(dto.getClientId())
                                .clientName(dto.getClientId())
                                .clientId(dto.getClientId())
                                .clientSecret(dto.getClientSecret())
                                // todo : Not Null Data
                                .authorizationGrantType(AuthorizationGrantType.JWT_BEARER)
                                .build())
                .collect(Collectors.toMap(
                        m -> m.getClientId(),
                        m -> m
                ));

    }

    public ClientIdDTO findById(String clientId) {
        return jdbcTemplate.queryForObject(
                """
                                       select client_id 
                                , client_secret
                                from app_client_id           
                                where client_id = ?
                        """,
                (rs, rowNum) -> ClientIdDTO.of(
                        rs.getString("client_id"),
                        rs.getString("client_secret")
                ),
                clientId
        );
    }
}
