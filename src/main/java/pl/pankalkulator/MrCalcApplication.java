package pl.pankalkulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MrCalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrCalcApplication.class, args);

	}


}
