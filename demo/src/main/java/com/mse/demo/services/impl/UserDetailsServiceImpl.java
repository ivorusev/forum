//package com.mse.demo.services.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.mse.demo.dto.UserPrincipal;
//import com.mse.demo.persistence.UserRepository;
//import com.mse.demo.persistence.entities.UserEntity;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) {
//		UserEntity user = userRepository.findByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException(username);
//		}
//		return new UserPrincipal(user);
//	}
//
//}
