package org.springframework.samples.petclinic;

import com.microsoft.applicationinsights.web.internal.WebRequestTrackingFilter;
import javax.servlet.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class PetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(ApplicationInsightsWebFilter());
		registration.addUrlPatterns("/*");
		registration.setName("ApplicationInsightsWebFilter");
		registration.setOrder(1);
		return registration;
	}

	public Filter ApplicationInsightsWebFilter() {
		return new WebRequestTrackingFilter();
	}
}
