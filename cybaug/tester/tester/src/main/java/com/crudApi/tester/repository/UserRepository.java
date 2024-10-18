package com.crudApi.tester.repository;

import com.crudApi.tester.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
