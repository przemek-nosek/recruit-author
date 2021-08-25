package pl.java.recruitauthor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.java.recruitauthor.dto.AuthorBookDto;
import pl.java.recruitauthor.entity.Author;
import pl.java.recruitauthor.exception.AuthorNotFoundException;
import pl.java.recruitauthor.exception.CategoryNotFoundException;
import pl.java.recruitauthor.repository.AuthorRepository;
import pl.java.recruitauthor.repository.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public AuthorBookDto getAuthorAndBooksInSingleCategory(Long id, String category) {

        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author not found"));

        boolean existsByCategoryName = categoryRepository.existsByCategoryName(category);

        if (!existsByCategoryName) {
            throw new CategoryNotFoundException("Category not found");
        }

        List<String> bookTitles = authorRepository.findTitlesByAuthorIdAndCategory(id, category);

        return new AuthorBookDto(author.getFirstName(), author.getLastName(), category, bookTitles.size(), bookTitles);
    }
}
