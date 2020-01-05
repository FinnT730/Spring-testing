package finnt730.imageGenerator;

import finnt730.imageGenerator.hello.storage.StorageProperties;
import finnt730.imageGenerator.hello.storage.StorageService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.beans.beancontext.BeanContext;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ImageGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageGeneratorApplication.class, args);
	}


//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//
//		};
//	}

	@Bean
	public CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			System.out.println(storageService.loadAll());
			storageService.deleteAll();
			storageService.init();
		};
	}




}

