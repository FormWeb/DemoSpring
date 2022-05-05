package com.example.demo;

import com.example.demo.models.entities.Author;
import com.example.demo.models.entities.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello");

//		Author author = new Author("JRR", "Tolkien", new ArrayList<>());
//		authorRepository.save(author);
//
//		Book book = new Book("Le seigneur des anneaux", "Les mecs cherchent un anneaux", author);
//		bookRepository.save(book);
	}
}
