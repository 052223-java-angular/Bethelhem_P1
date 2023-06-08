package com.revature.park.Repositories;

import java.util.Optional;

import com.revature.park.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 * The UserRepository interface provides database operations for User entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * Finds a user by username.
     *
     * @param username the username to search for
     * @return an Optional containing the User object if found, or an empty Optional
     *         otherwise
     */
    Optional<User> findByUsername(String username);
}
