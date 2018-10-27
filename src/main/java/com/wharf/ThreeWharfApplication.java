package com.wharf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class ThreeWharfApplication  extends SpringBootServletInitializer {

	/**
	 * 实现SpringBootServletInitializer可以让spring-boot项目在web容器中运行
	 */

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(ThreeWharfApplication.class);
		//springApplication.addListeners(new InitWxAccessToken());  //spring初始化完成时加就启动线程获取微信token
		springApplication.run(args);
		//SpringApplication.run(SpbootWeixiinApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}


	/**
	 * 跨域过滤器
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig()); // 4
		return new CorsFilter(source);
	}
	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		return corsConfiguration;
	}

}
