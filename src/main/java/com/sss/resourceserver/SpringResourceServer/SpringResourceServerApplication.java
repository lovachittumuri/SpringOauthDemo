package com.sss.resourceserver.SpringResourceServer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@RestController
public class SpringResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringResourceServerApplication.class, args);
	}

	Map<Integer, Account> map = new HashMap<>();

	@RequestMapping("/account")
	public Collection<Account> getAccountDetails() {
		if (ObjectUtils.isEmpty(map)) {
			map.put(123456, new Account(123456, "Saving", "Lova Chittumuri", "SBI"));
			map.put(123457, new Account(123457, "Saving", "Aruna Chittumuri", "ICICI"));
			map.put(123458, new Account(123458, "Current", "Rajesh Kasimalla", "HDFC"));
		}
		return map.values();

	}

}
