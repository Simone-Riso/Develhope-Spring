package co.develhope.esercizioMiddleware01;

import co.develhope.esercizioMiddleware01.interceptors.APILoggingInterceptor;
import co.develhope.esercizioMiddleware01.interceptors.LegacyInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EsercizioMiddleware01Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(EsercizioMiddleware01Application.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new APILoggingInterceptor());
		registry.addInterceptor(new LegacyInterceptor());
	}

}
