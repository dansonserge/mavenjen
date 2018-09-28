package com.hrm.HRM;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@Configuration
@RestController
//@EnableOAuth2Sso
@ComponentScan("com.hrm.HRM")
public class HrmApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HrmApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(HrmApplication.class, args);
	}
	
	 
	@Bean 
	public SessionFactory sessionFactory(org.hibernate.jpa.HibernateEntityManagerFactory h) {
	

	return h.getSessionFactory();
	}
}
