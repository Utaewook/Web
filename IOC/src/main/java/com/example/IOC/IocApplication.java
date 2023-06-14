package com.example.IOC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {
		SpringApplication.run(IocApplication.class, args);
		ApplicationContext context = ApplicationContextProvider.getContext();


//		Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//		UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
//
//		Encoder encoder = new Encoder(base64Encoder);
//		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
//
//		String result = encoder.encode(url);
//		System.out.println(result);
//
//		encoder.setIEncoder(urlEncoder);
//		result = encoder.encode(url);
//		System.out.println(result);


		// new로 생성되는 객체 없이 spring에서 객체 관리
//		Encoder encoder = context.getBean(Encoder.class);
//		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
//		String result = encoder.encode(url);
//		System.out.println(result);


		Encoder encoder1 = context.getBean("urlEncode",Encoder.class);
		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
		String result = encoder1.encode(url);
		System.out.println(result);
	}

}


@Configuration
class AppConfig{

	@Bean("baseEncode")
	public Encoder encoder(Base64Encoder base64Encoder){
		return new Encoder(base64Encoder);
	}

	@Bean("urlEncode")
	public Encoder encode(UrlEncoder urlEncoder){
		return new Encoder(urlEncoder);
	}
}

