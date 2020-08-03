package com.alexander.spring_security_boot.repository;

import com.alexander.spring_security_boot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
