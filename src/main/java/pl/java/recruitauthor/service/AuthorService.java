package pl.java.recruitauthor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.java.recruitauthor.dto.AuthorBookDto;
import pl.java.recruitauthor.entity.Author;
import pl.java.recruitauthor.exception.AuthorNotFoundException;
import pl.java.recruitauthor.repository.AuthorRepository;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorBookDto getAuthorAndBooksByCategory(Long id, String category) {
        Author author = authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);

        return null;
    }
}
