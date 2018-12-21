package com.tb.wiredcoffee.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {

	@Bean
	//@Profile("local")
	public JedisConnectionFactory jedisConnectionFactory() {
		
		JedisConnectionFactory bean = new JedisConnectionFactory();
		//bean.setHostName("test-prtcd-cache-001.test-prtcd-cache.y3hpjc.usw2.cache.amazonaws.com");
		bean.setHostName("localhost");
		bean.setPort(6379);
		//bean.setPassword("Th1sIsMyT3stPassword1");
		//bean.setUseSsl(true);
		
		return bean;
	}
	
	@Bean
	public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
		
		StringRedisTemplate bean = new StringRedisTemplate(jedisConnectionFactory);
		
		return bean;
	}
}
