package pl.java.recruitauthor.dto;

import java.io.Serializable;

public record AuthorBookDto(String authorName, String category, int bookCount) implements Serializable {

}
