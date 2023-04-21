package com.flab.LiveCommerce.user.infrastructure.config

import com.flab.LiveCommerce.user.application.CheckEmailProcessor
import com.flab.LiveCommerce.user.application.CreateUserProcessor
import com.flab.LiveCommerce.user.application.LoginUserProcessor
import com.flab.LiveCommerce.user.application.LogoutUserProcessor
import com.flab.LiveCommerce.user.domain.PasswordEncryptor
import com.flab.LiveCommerce.user.domain.TokenGenerator
import com.flab.LiveCommerce.user.domain.TokenRepository
import com.flab.LiveCommerce.user.domain.UserRepository
import com.flab.LiveCommerce.user.infrastructure.encryption.UserSecurityPasswordEncoder
import com.flab.LiveCommerce.user.infrastructure.generator.NonInfoTokenGenerator
import com.flab.LiveCommerce.user.infrastructure.tokenproperties.TokenProperties
import com.flab.user.application.CheckEmailProcessor
import com.flab.user.application.CreateUserProcessor
import com.flab.user.application.LoginUserProcessor
import com.flab.user.application.LogoutUserProcessor
import com.flab.user.domain.PasswordEncryptor
import com.flab.user.domain.TokenGenerator
import com.flab.user.domain.TokenRepository
import com.flab.user.domain.UserRepository
import com.flab.user.infrastructure.encryption.UserSecurityPasswordEncoder
import com.flab.user.infrastructure.generator.NonInfoTokenGenerator
import com.flab.user.infrastructure.tokenproperties.TokenProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class UserConfig {
    @Bean
    fun createUserProcessor(
        userRepository: UserRepository,
        passwordEncryptor: PasswordEncryptor
    ): CreateUserProcessor {
        return CreateUserProcessor(
            userRepository,
            passwordEncryptor
        )
    }

    @Bean
    fun loginUserProcessor(
        userRepository: UserRepository,
        tokenGenerator: TokenGenerator,
        tokenRepository: TokenRepository,
        passwordEncryptor: PasswordEncryptor,
        tokenProperties: TokenProperties
    ): LoginUserProcessor {
        return LoginUserProcessor(
            userRepository,
            tokenGenerator,
            tokenRepository,
            passwordEncryptor,
            tokenProperties.tokenExpirationSec
        )
    }

    @Bean
    fun emailProcessor(userRepository: UserRepository?): CheckEmailProcessor {
        return CheckEmailProcessor(userRepository)
    }

    @Bean
    fun logoutUserProcessor(tokenRepository: TokenRepository): LogoutUserProcessor {
        return LogoutUserProcessor(tokenRepository)
    }

    @Bean
    fun tokenGenerator(): TokenGenerator {
        return NonInfoTokenGenerator()
    }

    @Bean
    fun passwordEncryptor(passwordEncoder: PasswordEncoder): UserSecurityPasswordEncoder {
        return UserSecurityPasswordEncoder(passwordEncoder)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
