package com.example.demo.services;

import com.example.demo.mapper.AuthorMapper;
import com.example.demo.models.dto.AuthorDTO;
import com.example.demo.models.entities.Author;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public AuthorDTO saveAuthor(AuthorDTO author) {
        return authorMapper.toDto(
                authorRepository.save(authorMapper.toEntity(author))
        );
    }

    public List<AuthorDTO> getAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(int id) {
        return authorMapper.toDto(authorRepository.findById(id).orElse(null));
    }

    public String deleteAuthor(int id) {
        authorRepository.deleteById(id);
        return "Author removed";
    }

    public AuthorDTO updateAuthor(AuthorDTO author) {
        if (author.getId() != 0) {
            Author currentAuthor = authorRepository.findById(author.getId()).orElse(null);
            if (currentAuthor != null) {
                if (author.getFirstName() != null) {
                    currentAuthor.setFirstName(author.getFirstName());
                }
                if (author.getLastName() != null) {
                    currentAuthor.setLastName(author.getLastName());
                }
                return authorMapper.toDto(authorRepository.save(currentAuthor));
            }
            else {
                return null;
            }

        }
        else {
            return null;
        }
    }
}
