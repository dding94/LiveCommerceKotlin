package com.flab.LiveCommerce.user.infrastructure.persistence.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.common.auth.AuthenticatedUser;
import com.flab.user.infrastructure.tokenproperties.TokenProperties;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisTokenRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;
    private final TokenProperties tokenProperties;

    public RedisTokenRepository(
        RedisTemplate<String, Object> redisTemplate,
        ObjectMapper objectMapper,
        TokenProperties tokenProperties
    ) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
        this.tokenProperties = tokenProperties;
    }

    public void save(AuthenticatedUser authenticatedUser) {
        redisTemplate.opsForValue().set(
            authenticatedUser.getToken(),
            authenticatedUser,
            Duration.ofSeconds(tokenProperties.getTokenExpirationSec())
        );
    }

    public AuthenticatedUser findByToken(String token) {
        var result = redisTemplate.opsForValue().get(token);

        if (result == null) {
            return null;
        }

        return objectMapper.convertValue(result, AuthenticatedUser.class);
    }

    public void renewExpirationSec(AuthenticatedUser authenticatedUser) {
        long expirationTime = calculateExpirationTime(authenticatedUser);
        authenticatedUser.plusSecondExpiration(expirationTime);

        redisTemplate.opsForValue().set(
            authenticatedUser.getToken(),
            authenticatedUser,
            Duration.ofSeconds(tokenProperties.getTokenExpirationSec())
        );
    }

    private long calculateExpirationTime(AuthenticatedUser authenticatedUser) {
        Long propertiesExpirationSec = tokenProperties.getTokenExpirationSec();
        Long userExpirationSec = redisTemplate.getExpire(
            authenticatedUser.getToken(),
            TimeUnit.SECONDS
        );

        if (userExpirationSec == null) {
            throw new IllegalArgumentException();
        }

        if (propertiesExpirationSec - userExpirationSec <= 0) {
            return tokenProperties.getTokenExpirationSec();
        }

        return propertiesExpirationSec - userExpirationSec;
    }

    public void remove(String token) {
        redisTemplate.delete(token);
    }

}
