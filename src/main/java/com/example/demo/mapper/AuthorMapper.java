package com.example.demo.mapper;

import com.example.demo.models.dto.AuthorDTO;
import com.example.demo.models.entities.Author;
import com.example.demo.models.entities.Book;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AuthorMapper {

    private AuthorDTO.BookDTO bookToDto(Book book) {
        return new AuthorDTO.BookDTO(
                book.getTitle(),
                book.getResume()
        );
    }

    public AuthorDTO toDto(Author author) {
        if (author == null) {
            return null;
        }

        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());

        if (author.getBooks() != null) {
            dto.setBooks(author.getBooks()
                    .stream()
                    .map(this::bookToDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public Author toEntity(AuthorDTO authorDTO) {
        if (authorDTO == null) {
            return null;
        }

        Author entity = new Author();
        entity.setId(authorDTO.getId());
        entity.setFirstName(authorDTO.getFirstName());
        entity.setLastName(authorDTO.getLastName());
        return entity;
    }
}
