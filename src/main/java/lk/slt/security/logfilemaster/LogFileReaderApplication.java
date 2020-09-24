package lk.slt.security.logfilemaster;

import lk.slt.security.logfilemaster.properties.StorageProperties;
import lk.slt.security.logfilemaster.services.StorageService;
//import lk.slt.security.logfilemaster.repository.UserRepository;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableConfigurationProperties(StorageProperties.class)
public class LogFileReaderApplication {

//    private static final Logger logger = LogManager.getLogger(LogFileReaderApplication.class);
//
//    public static void main(String[] args) {
//        SpringApplication.run(LogFileReaderApplication.class, args);
//    }
//
//    @Override
//    public void run(ApplicationArguments applicationArguments) throws Exception {
//        logger.debug("Debugging log");
//        logger.info("Info log");
//        logger.warn("Hey, This is a warning!");
//        logger.error("Oops! We have an Error. OK");
//        logger.fatal("Damn! Fatal error. Please fix me.");
//
//
//    }
//
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