package pl.java.recruitauthor.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.java.recruitauthor.dto.AuthorBookDto;
import pl.java.recruitauthor.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}/{category}")
    public ResponseEntity<AuthorBookDto> getAuthorAndBooksInCategory(@PathVariable Long id, @PathVariable String category) {
        AuthorBookDto dto = authorService.getAuthorAndBooksInSingleCategory(id, category);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}/categories")
    public ResponseEntity<List<AuthorBookDto>> getAuthorBooksGroupedByCategory(@PathVariable Long id) {
        List<AuthorBookDto> dtoList = authorService.getAuthorBooksGroupedByCategory(id);

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
