package com.example.demo.models.dto;

import com.example.demo.models.entities.Author;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class BookDTO {
    private int id;

    private String title;

    private String resume;

    @JsonIgnore
    private AuthorDTO author;

    private String authorName;

    public BookDTO() {
    }

    public BookDTO(String title, String resume, AuthorDTO author) {
        this.title = title;
        this.resume = resume;
        this.author = author;
    }

    public BookDTO(int id, String title, String resume, AuthorDTO author) {
        this.id = id;
        this.title = title;
        this.resume = resume;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public String getAuthorName() {
        return author.getFirstName() + " " + author.getLastName();
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", resume='" + resume + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
