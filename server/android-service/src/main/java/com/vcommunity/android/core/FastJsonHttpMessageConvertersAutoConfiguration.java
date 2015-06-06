package com.vcommunity.android.core;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.Collections;
import java.util.List;

@Configuration
@ConditionalOnClass(HttpMessageConverter.class)
public class FastJsonHttpMessageConvertersAutoConfiguration {

	@Autowired(required = false)
	private final List<HttpMessageConverter<?>> converters = Collections.emptyList();

	@Bean(name = "messageConverters")
	public HttpMessageConverters messageConverters() {
		return new HttpMessageConverters(this.converters);
	}

	@Configuration
	protected static class ObjectMappers {

		@Bean
		public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(ObjectMapper objectMapper) {
			FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
			return converter;
		}

	}

}