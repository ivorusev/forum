//package com.mse.demo.controllers;
//
//import java.security.Principal;
//import java.util.Base64;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin
//public class UserController {
//	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<String> login(@RequestBody User user) {
//		String token = user.getName() + ":" + user.getPassword();
//		byte[] bytesEncoded = Base64.getEncoder().encode(token.getBytes());
//		ResponseEntity<String> responseEntity = new ResponseEntity<String>(new String(bytesEncoded), HttpStatus.OK);
//		return responseEntity;
//	}
//
//	@RequestMapping("/user")
//	public Principal user(HttpServletRequest request) {
//		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
//		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
//	}
//
//}
