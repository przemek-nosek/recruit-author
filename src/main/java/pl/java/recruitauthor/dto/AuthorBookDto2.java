package pl.java.recruitauthor.dto;

import java.io.Serializable;
import java.util.List;

public record AuthorBookDto2(String authorName, String category, Long bookCount, List<String> titles) implements Serializable {
}

