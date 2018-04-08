package com.ewp.crm.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ThymeleafConfig {
	private final static String PREFIX = "eMailTemplateText:";

	@Bean
	public TemplateResolver springThymeleafTemplateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html");
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public StringTemplateResolver stringTemplateResolver() {
		StringTemplateResolver resolver = new StringTemplateResolver();
		resolver.setCharacterEncoding("UTF-8");
		resolver.setPREFIX(PREFIX);
		resolver.setOrder(3);
		return resolver;
	}

	@Bean
	public SpringTemplateEngine thymeleafTemplateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		Set<TemplateResolver> templateResolverSet = new HashSet<>();
		templateResolverSet.add(springThymeleafTemplateResolver());
		templateResolverSet.add(stringTemplateResolver());
		engine.setTemplateResolvers(templateResolverSet);
		return engine;
	}
}
