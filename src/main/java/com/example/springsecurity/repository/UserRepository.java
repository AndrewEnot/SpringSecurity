package com.example.springsecurity.repository;

import com.example.springsecurity.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Oksiuta Andrii
 * 06.02.2023
 * 14:59
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  Optional<User> findFirstByName(String name);

  boolean existsUserByName(String name);

}
