package com.teaminternational;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@PropertySource("classpath:application.properties")
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/panel").setViewName("panel");
        registry.addViewController("/moderator").setViewName("moderator");
        registry.addViewController("/create").setViewName("create");
        registry.addViewController("/exchange").setViewName("exchange");
        registry.addViewController("/finish").setViewName("finish");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/rename").setViewName("rename");
        registry.addViewController("/tryagain").setViewName("tryagain");
    }
}
