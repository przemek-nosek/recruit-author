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

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}/{category}")
    public ResponseEntity<AuthorBookDto> getAuthorAndBooksByCategory(@PathVariable Long id, @PathVariable String category) {
        AuthorBookDto dto = authorService.getAuthorAndBooksByCategory(id, category);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
