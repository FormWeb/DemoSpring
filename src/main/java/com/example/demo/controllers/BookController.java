package com.example.demo.controllers;

import com.example.demo.models.dto.BookDTO;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("{id}")
    public BookDTO getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/author/{id}")
    public List<BookDTO> getBookByAuthor(@PathVariable int id) {
        return bookService.getBooksByAuthor(id);
    }

    @PostMapping("{idAuthor}")
    public BookDTO addBook(@RequestBody BookDTO book, @PathVariable int idAuthor) {
        return bookService.saveBook(book, idAuthor);
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }

    @PutMapping
    public BookDTO updateBook(@RequestBody BookDTO book) {
        return bookService.updateBook(book);
    }
}
