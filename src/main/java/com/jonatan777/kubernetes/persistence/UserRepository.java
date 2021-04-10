package com.jonatan777.kubernetes.persistence;

import org.springframework.data.repository.CrudRepository;

import com.jonatan777.kubernetes.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}

