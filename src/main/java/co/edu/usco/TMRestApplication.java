package co.edu.usco;

import co.edu.usco.TM.persistence.entity.administration.Role;
import co.edu.usco.TM.persistence.repository.RoleRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TMRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TMRestApplication.class, args);
    }

}
