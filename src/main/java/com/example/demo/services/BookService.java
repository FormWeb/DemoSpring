package com.example.demo.services;

import com.example.demo.mapper.BookMapper;
import com.example.demo.models.dto.BookDTO;
import com.example.demo.models.entities.Author;
import com.example.demo.models.entities.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookMapper bookMapper;

    public BookDTO saveBook(BookDTO book, int idAuthor) {
        Book bookEntity = bookMapper.toEntity(book);
        Author author = authorRepository.findById(idAuthor).orElse(null);
        bookEntity.setAuthor(author);
        return bookMapper.toDto(
                bookRepository.save(bookEntity)
        );
    }

    public List<BookDTO> getBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(int id) {
        return bookMapper.toDto(bookRepository.findById(id).orElse(null));
    }

    public List<BookDTO> getBooksByAuthor(int id) {
        Author author = authorRepository.findById(id).orElse(null);
        return bookRepository.findByAuthor(author)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "Book removed";
    }

    public BookDTO updateBook(BookDTO book) {
        if (book.getId() != 0) {
            System.out.println(book.getId());
            Book currentBook = bookRepository.findById(book.getId()).orElse(null);
            if (currentBook != null) {
                if (book.getTitle() != null) {
                    currentBook.setTitle(book.getTitle());
                }
                if (book.getResume() != null) {
                    currentBook.setResume(book.getResume());
                }
                return bookMapper.toDto(bookRepository.save(currentBook));
            }
            else {
                return null;
            }

        }
        else {
            return null;
        }
      }
//        if (book != null) {
//            bookRepository.updateBook(book.getTitle(), book.getResume(), book.getId());
//            return "Updated";
//        }
//
//        return null;
}
