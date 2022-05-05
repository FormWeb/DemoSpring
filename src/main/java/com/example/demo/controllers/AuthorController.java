package com.example.demo.controllers;

import com.example.demo.models.dto.AuthorDTO;
import com.example.demo.models.entities.Author;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@CrossOrigin
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("{id}")
    public AuthorDTO getAuthorById(@PathVariable int id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public AuthorDTO addAuthor(@RequestBody AuthorDTO author) {
        return authorService.saveAuthor(author);
    }

    @DeleteMapping("{id}")
    public String deleteAuthor(@PathVariable int id) {
        return authorService.deleteAuthor(id);
    }

    @PutMapping
    public AuthorDTO updateAuthor(@RequestBody AuthorDTO author) {
        return authorService.updateAuthor(author);
    }
}
