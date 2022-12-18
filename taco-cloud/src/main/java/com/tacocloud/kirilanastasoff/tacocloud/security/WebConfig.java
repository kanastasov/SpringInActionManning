package com.tacocloud.kirilanastasoff.tacocloud.security;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

public class WebConfig {
//	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/login");
	}
}
