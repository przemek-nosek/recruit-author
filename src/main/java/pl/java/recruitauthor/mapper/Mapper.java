package pl.java.recruitauthor.mapper;


import pl.java.recruitauthor.dto.BookDto;
import pl.java.recruitauthor.entity.Book;

public class Mapper {

    public static BookDto toBookDto(Book book) {
        return new BookDto(book.getTitle());
    }
}
