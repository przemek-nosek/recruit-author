package pl.java.recruitauthor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.java.recruitauthor.dto.AuthorBookDto;
import pl.java.recruitauthor.repository.AuthorRepository;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorBookDto getAuthorAndBooksByCategory(Long id, String category) {
        authorRepository.findById(id);

        return null;
    }
}
