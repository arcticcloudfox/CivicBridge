package com.civicbridge.models.data;

import com.civicbridge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    void deleteById(int userId);

    boolean existsByUsername(String username);

    User findByEmail(String email);
}
