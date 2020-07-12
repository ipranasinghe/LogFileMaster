package app.slt.soa.filereader;

import app.slt.soa.filereader.repository.UserRepository;
import app.slt.soa.filereader.storage.StorageProperties;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import app.slt.soa.filereader.storage.StorageService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableConfigurationProperties(StorageProperties.class)

public class LogFileReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogFileReaderApplication.class, args); }


	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

	}




