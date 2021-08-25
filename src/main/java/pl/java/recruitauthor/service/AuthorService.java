package pl.java.recruitauthor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.java.recruitauthor.dto.AuthorBookDto;
import pl.java.recruitauthor.dto.AuthorDto;
import pl.java.recruitauthor.entity.Author;
import pl.java.recruitauthor.exception.AuthorNotFoundException;
import pl.java.recruitauthor.exception.CategoryNotFoundException;
import pl.java.recruitauthor.projection.BookNameCategory;
import pl.java.recruitauthor.repository.AuthorRepository;
import pl.java.recruitauthor.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public AuthorBookDto getAuthorAndBooksInSingleCategory(Long id, String category) {

        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author not found"));

        boolean existsByCategoryName = categoryRepository.existsByCategoryName(category);

        if (!existsByCategoryName) {
            throw new CategoryNotFoundException("Category not found");
        }

        List<String> bookTitles = authorRepository.findTitlesByAuthorIdAndCategory(id, category);

        return new AuthorBookDto(author.getFirstName(), author.getLastName(), category, bookTitles.size(), bookTitles);
    }

    public List<AuthorBookDto> getAuthorBooksGroupedByCategory(Long id) {

        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author not found"));

        List<BookNameCategory> bookNameCategories = authorRepository.findAllAuthorBooksGroupedByCategory(id);

        List<AuthorBookDto> dtos = new ArrayList<>();

        Map<String, List<String>> collect = bookNameCategories.stream()
                .collect(groupingBy(BookNameCategory::getCategory, mapping(BookNameCategory::getName, toList())));


        for (String category : collect.keySet()) {
            List<String> titles = collect.get(category);

            dtos.add(new AuthorBookDto(
                    author.getFirstName(),
                    author.getLastName(),
                    category,
                    titles.size(),
                    titles
                    ));
        }

        return dtos;
    }

    public List<AuthorDto> getAllAuthorsAndGroupByCategory() {
        return authorRepository.findAllAuthorsAndGroupByCategory();
    }
}
