package com.mse.demo.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mse.demo.ForumApplication;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = ForumApplication.class)
public class OAuthMvcTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@Before
	public void setup() {
		MockMvcBuilders.webAppContextSetup(this.wac)
				.addFilter(springSecurityFilterChain)
				.build();
	}
}
