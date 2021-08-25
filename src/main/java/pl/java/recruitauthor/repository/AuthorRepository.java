package pl.java.recruitauthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.java.recruitauthor.entity.Author;
import pl.java.recruitauthor.projection.BookNameCategory;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "select b.title " +
            "from authors a, books b, authors_books ab, categories c " +
            "where " +
            "a.id = :id and a.id=ab.author_id and ab.book_id=b.id and c.category_name=upper (:category) and c.id = b.category_id group by b.title",
            nativeQuery = true)
    List<String> findTitlesByAuthorIdAndCategory(Long id, String category);


    @Query(value = "select b.title as name, c.category_name as category " +
            "from authors a, books b, authors_books ab, categories c " +
            "where " +
            "a.id = :id and a.id=ab.author_id and ab.book_id=b.id  and c.id = b.category_id group by b.title",
            nativeQuery = true)
    List<BookNameCategory> uga2(Long id);
}
