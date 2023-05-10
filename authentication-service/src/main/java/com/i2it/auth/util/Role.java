package com.i2it.auth.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {

  USER(Set.of(
          Permission.READ)),
  ADMIN(
          Set.of(
                  Permission.READ,
                  Permission.UPDATE,
                  Permission.DELETE,
                  Permission.CREATE

          )
  ),
  MANAGER(
          Set.of(
                  Permission.READ,
                  Permission.UPDATE,
                  Permission.DELETE,
                  Permission.CREATE
          )
  )

  ;

  @Getter
  private final Set<Permission> permissions;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}
