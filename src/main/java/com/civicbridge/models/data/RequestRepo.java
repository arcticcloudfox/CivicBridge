package com.civicbridge.models.data;

import com.civicbridge.models.Request;
import com.civicbridge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepo extends JpaRepository<Request, Integer> {
    List<Request> findAll();
    List<Request> findByUser(User user);
    Request findRequestById(int id);
    void deleteById(int id);
}
