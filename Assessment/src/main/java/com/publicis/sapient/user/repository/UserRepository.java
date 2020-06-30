package com.publicis.sapient.user.repository;

import com.publicis.sapient.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link User}s.
 *
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findOne(Long id);

    @Query("SELECT u FROM User u WHERE u.username = ?1 OR u.email = ?1")
    User findByUsernameOrEmail(String identifier);
}