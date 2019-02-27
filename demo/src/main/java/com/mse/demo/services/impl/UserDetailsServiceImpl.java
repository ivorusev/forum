package com.mse.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mse.demo.persistence.UsersRepository;
import com.mse.demo.persistence.entities.UserEntity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UserEntity user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));

		List<SimpleGrantedAuthority> collect = user.getRoles()
				.stream()
				.map(roles -> new SimpleGrantedAuthority(roles.getRoleName()))
				.collect(Collectors.toList());

		return org.springframework.security.core.userdetails.User.builder()
				.username(user.getUsername())
				.password(passwordEncoder().encode(user.getPassword()))
				.authorities(collect)
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
