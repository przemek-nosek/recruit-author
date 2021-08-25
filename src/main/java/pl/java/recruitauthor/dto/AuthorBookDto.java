package pl.java.recruitauthor.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


public record AuthorBookDto(String authorName, String category, int bookCount,
                            List<BookDto> books) implements Serializable {
}

