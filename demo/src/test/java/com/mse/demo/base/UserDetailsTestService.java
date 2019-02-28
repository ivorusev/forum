package com.mse.demo.mocks;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;

@Service
@Primary
@ActiveProfiles("test")
public class UserDetailsTestService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return new User("dummyUser", "dummyPassword", true, true, true, true,
				AuthorityUtils.createAuthorityList("USER"));
	}
}
