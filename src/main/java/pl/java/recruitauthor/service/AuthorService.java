package pl.java.recruitauthor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.java.recruitauthor.dto.AuthorBookDto;
import pl.java.recruitauthor.dto.BookDto;
import pl.java.recruitauthor.entity.Author;
import pl.java.recruitauthor.entity.Book;
import pl.java.recruitauthor.exception.AuthorNotFoundException;
import pl.java.recruitauthor.mapper.Mapper;
import pl.java.recruitauthor.repository.AuthorRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public AuthorBookDto getAuthorAndBooksByCategory(Long id, String category) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author not found"));

        Set<Book> books = author.getBooks();

        List<BookDto> categorizedBooks = books.stream()
                .filter(book -> book.getCategory().getCategoryName().equalsIgnoreCase(category))
                .map(Mapper::toBookDto)
                .collect(Collectors.toList());


        return new AuthorBookDto(
                author.getFirstName(),
                category,
                categorizedBooks.size(),
                categorizedBooks
        );
    }
}
