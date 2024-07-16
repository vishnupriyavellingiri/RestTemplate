package net.javaguides.employeeservice1;

import org.apache.catalina.loader.WebappClassLoader;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeService1Application {
	@Bean
    public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
    @Bean
	public WebClient webClient()
	{
		return WebClient.builder().build();
	}

//	@Bean
//	public RestTemplate restTemplate()
//	{
//		return new RestTemplate();
//	}
	public static void main(String[] args)
	{
		SpringApplication.run(EmployeeService1Application.class, args);
	}
}
