package pl.java.recruitauthor.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String isbn; // TODO: add ISBN validation

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String title;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category category;

    public Book(String isbn, String title, Set<Author> authors, Category category) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.category = category;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
    }

}
