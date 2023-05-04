package com.i2it.security.token;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Integer> {


  List<Token> findAllByUserName(String userName);

  Optional<Token> findByToken(String token);
}
