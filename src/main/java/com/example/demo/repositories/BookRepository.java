package com.example.demo.repositories;

import com.example.demo.models.entities.Author;
import com.example.demo.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthor(Author author);
    //    @Modifying
    //    @Transactional
    //    @Query(value = "update Book b set b.title = :title, b.resume = :resume where b.id = :id")
    //    void updateBook(@Param(value = "title") String title, @Param(value = "resume") String resume,
    //                    @Param(value = "id") int id);
}
