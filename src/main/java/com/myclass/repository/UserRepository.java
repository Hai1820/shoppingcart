package com.myclass.repository;

import com.myclass.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findById(long id);
}
