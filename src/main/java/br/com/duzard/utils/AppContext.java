package br.com.duzard.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

import br.com.duzard.user.security.SecurityFiltros;

@Configuration
@EnableAutoConfiguration
@EnableCaching
@ComponentScan(basePackages = { "br.com.duzard" })
public class AppContext {
	
	@Bean
	public FilterRegistrationBean getFiltroJwt(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new SecurityFiltros());
		frb.addUrlPatterns("/api/*");
		
		return frb;
	}
	
	@Bean
	public CacheManager cacheManeger(){
		CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder()
		.maximumSize(300)
		.expireAfterAccess(30, TimeUnit.DAYS);
		GuavaCacheManager manager = new GuavaCacheManager();
		manager.setCacheBuilder(builder);
		return manager;
	}
	

}
