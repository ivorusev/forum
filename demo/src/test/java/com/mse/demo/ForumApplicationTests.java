package com.mse.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.common.util.JacksonJsonParser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ForumApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		// TODO:
		// String accessToken = obtainAccessToken("dummyUser", "dummyPassword");
	}

	private String obtainAccessToken(String username, String password) throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "password");
		params.add("username", username);
		params.add("password", password);
		// params.add("scope", "openid");

		String base64ClientCredentials = new String(Base64.encodeBase64("admin:secret".getBytes()));

		ResultActions result = mockMvc.perform(post("http://localhost:8090/oauth/token").params(params)
				.header("Authorization", "Basic " + base64ClientCredentials)
				.accept("application/json;charset=UTF-8"))
				.andExpect(status().isOk());

		String resultString = result.andReturn()
				.getResponse()
				.getContentAsString();

		JacksonJsonParser jsonParser = new JacksonJsonParser();
		return jsonParser.parseMap(resultString)
				.get("access_token")
				.toString();
	}

}
