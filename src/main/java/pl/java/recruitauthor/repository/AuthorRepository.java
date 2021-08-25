package pl.java.recruitauthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.java.recruitauthor.dto.AuthorBookDto;
import pl.java.recruitauthor.dto.IAuthorBookDto;
import pl.java.recruitauthor.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query(value = "select a.first_name, c.category_name, b.title,  from authors a, books b, authors_books ab, categories c where\n" +
            "a.id = 2 and a.id=ab.author_id and ab.book_id=b.id and c.category_name='COMEDY' and c.id = b.category_id group by b.title",
            nativeQuery = true)
    List<AuthorBookDto> find(Long id, String category);

//    @Query("select new pl.java.recruitauthor.dto.AuthorBookDto2(a.firstName, c.categoryName, count (b.title), b.title)" +
//            "from Author a, Category c, Book b")
//    List<AuthorBookDto> test(Long id, String category);

    @Query(value = "select a.first_name as authorName, c.category_name as category, b.title as title from authors a, books b, authors_books ab, categories c where\n" +
            "a.id = :id and a.id=ab.author_id and ab.book_id=b.id and c.category_name=upper (:category) and c.id = b.category_id group by b.title",
            nativeQuery = true)
    List<IAuthorBookDto> fsasa(Long id, String category);
}
