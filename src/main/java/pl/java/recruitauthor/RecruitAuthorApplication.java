package pl.java.recruitauthor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.java.recruitauthor.dto.AuthorBookDto;
import pl.java.recruitauthor.dto.IAuthorBookDto;
import pl.java.recruitauthor.repository.AuthorRepository;

import java.util.List;

@SpringBootApplication
public class RecruitAuthorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitAuthorApplication.class, args);


    }

    @Bean
    CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
        return args -> {
            List<IAuthorBookDto> fsasa = authorRepository.fsasa(2L, "comedy");

            System.out.println("gdjhsgds");

            fsasa.forEach(f -> System.out.println(f.getAuthorName() + f.getTitle() + f.getCategory()));
        };
    }
}
