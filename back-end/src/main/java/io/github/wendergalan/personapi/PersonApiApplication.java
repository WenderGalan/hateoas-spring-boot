package io.github.wendergalan.personapi;

import io.github.wendergalan.personapi.models.entities.PhysicalPerson;
import io.github.wendergalan.personapi.repositories.PhysicalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static io.github.wendergalan.personapi.models.entities.PhysicalPerson.generatePhysicalPerson;

/**
 * The type person api application.
 */
@SpringBootApplication
public class PersonApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PersonApiApplication.class);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PersonApiApplication.class, args);
    }

    // https://docs.spring.io/spring-data/rest/docs/current/reference/html/#preface
    // POPULATE DATABASE
    @Autowired
    private PhysicalPersonRepository physicalPersonRepository;

    @PostConstruct
    @Transactional
    public void onLoad() {
        List<PhysicalPerson> people = new ArrayList<>();
        people.add(generatePhysicalPerson("Wender Galan"));
        people.add(generatePhysicalPerson("José Farias"));
        people.add(generatePhysicalPerson("Bruno Bereira"));
        people.add(generatePhysicalPerson("Rapaz do Céu"));
        people.add(generatePhysicalPerson("Maria Josefa de Souza Cardoso"));
        people.add(generatePhysicalPerson("Pedro Rodolfo"));
        people.add(generatePhysicalPerson("Leonardo das Costas"));
        physicalPersonRepository.saveAll(people);
    }
}
