package pl.java.recruitauthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.java.recruitauthor.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
