package com.vegetables;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.sql.DataSource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class VegetablesApplication extends SpringBootServletInitializer {

	/**
	 * 实现SpringBootServletInitializer可以让spring-boot项目在web容器中运行
	 */

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(VegetablesApplication.class);
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


	@EnableAsync
	@Configuration
	class TaskPoolConfig {
		/**
		 * 核心线程数10：线程池创建时候初始化的线程数
		 * 最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
		 * 缓冲队列200：用来缓冲执行任务的队列
		 * 允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
		 * 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
		 * 线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
		 *
		 * @return
		 */
		@Bean("asyncThread")
		public Executor taskExecutor() {
			//通过使用ThreadPoolTaskExecutor创建了一个线程池，同时设置了以下这些参数
			ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
			executor.setCorePoolSize(10);
			executor.setMaxPoolSize(20);
			executor.setQueueCapacity(200);
			executor.setKeepAliveSeconds(60);
			executor.setThreadNamePrefix("asyncThread-");
			executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
			return executor;
		}
	}

	@Bean
	public DataLoader dataLoader() {
		return new DataLoader();
	}

	static class DataLoader implements CommandLineRunner {
		@Override
		public void run(String... strings) throws Exception {
			System.out.println("Loading data......................................................");
		}
	}

	/**
	 * 阿里Druid监控功能
	 *
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}

}
