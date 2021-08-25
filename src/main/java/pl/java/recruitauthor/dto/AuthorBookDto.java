package pl.java.recruitauthor.dto;

import java.io.Serializable;
import java.util.List;


public record AuthorBookDto(String authorFirstName, String authorLastName, String category, int bookCount,
                            List<String> titles) implements Serializable {
}


