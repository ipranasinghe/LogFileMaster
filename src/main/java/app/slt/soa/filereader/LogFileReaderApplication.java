package app.slt.soa.filereader;

import app.slt.soa.filereader.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class LogFileReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogFileReaderApplication.class, args);
	}

}
