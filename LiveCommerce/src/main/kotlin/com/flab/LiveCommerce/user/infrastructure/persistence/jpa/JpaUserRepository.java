package com.flab.LiveCommerce.user.infrastructure.persistence.jpa;

import com.flab.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
