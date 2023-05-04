package com.i2it.auth.repository;

import java.util.List;
import java.util.Optional;

import com.i2it.auth.token.Token;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Integer> {


  List<Token> findAllByUserName(String userName);

  Optional<Token> findByToken(String token);
}
