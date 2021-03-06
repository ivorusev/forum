package com.mse.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.common.util.JacksonJsonParser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ForumApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockMvcBuilders.webAppContextSetup(this.wac)
				.addFilter(springSecurityFilterChain)
				.build();
	}

	@Test
	public void contextLoads() throws Exception {
		String accessToken = obtainAccessToken2("user", "pass");
		mockMvc.perform(get("/topics").header("Authorization", "Bearer " + accessToken)
				.accept("application/json;charset=UTF-8"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().string("[]"));
	}

	private String obtainAccessToken2(String username, String password) throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "password");
		params.add("username", username);
		params.add("password", password);

		String base64ClientCredentials = new String(Base64.encodeBase64("admin:secret".getBytes()));
		ResultActions result = mockMvc.perform(post("/oauth/token").params(params)
				.header("Authorization", "Basic " + base64ClientCredentials)
				.accept("application/json;charset=UTF-8"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));

		String resultString = result.andReturn()
				.getResponse()
				.getContentAsString();

		JacksonJsonParser jsonParser = new JacksonJsonParser();
		return jsonParser.parseMap(resultString)
				.get("access_token")
				.toString();
	}

}
