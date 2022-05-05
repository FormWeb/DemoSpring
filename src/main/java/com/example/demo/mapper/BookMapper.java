package com.example.demo.mapper;

import com.example.demo.models.dto.BookDTO;
import com.example.demo.models.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    @Autowired
    private AuthorMapper authorMapper;

    public BookDTO toDto(Book book) {
        if (book == null) {
            return null;
        }

        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setResume(book.getResume());
        dto.setTitle(book.getTitle());
        dto.setAuthor(authorMapper.toDto(book.getAuthor()));

        return dto;
    }

    public Book toEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }

        Book entity = new Book();
        entity.setId(bookDTO.getId());
        entity.setAuthor(authorMapper.toEntity(bookDTO.getAuthor()));
        entity.setTitle(bookDTO.getTitle());
        entity.setResume(bookDTO.getResume());

        return entity;
    }
}
