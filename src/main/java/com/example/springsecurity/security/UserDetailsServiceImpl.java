package com.example.springsecurity.security;

import com.example.springsecurity.model.User;
import com.example.springsecurity.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 * @author Oksiuta Andrii
 * 06.02.2023
 * 17:24
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    User byName = userRepository.findFirstByName(username)
        .orElseThrow(EntityNotFoundException::new);

    Set<GrantedAuthority> roles = new HashSet<>();
    roles.add(new SimpleGrantedAuthority(byName.getUserRole().name()));

    return new org.springframework.security.core.userdetails.User(byName.getName(),
        byName.getPassword(), roles);
  }
}
