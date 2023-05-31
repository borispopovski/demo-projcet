package mk.seavus.demoprojcet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoProjcetApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjcetApplication.class, args);
	}

}
