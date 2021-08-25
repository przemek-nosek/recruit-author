package pl.java.recruitauthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.java.recruitauthor.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
