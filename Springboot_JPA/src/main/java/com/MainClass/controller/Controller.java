package com.MainClass.controller;

import java.time.LocalDate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MainClass.entity.BookOperations;
import com.MainClass.entity.Book;

@RestController
public class Controller {

	@Autowired
	private BookOperations db;

	@PostMapping("/insert")
	public ResponseEntity<Book> insert(@RequestBody Book book) {
		try {
			book.setDate(LocalDate.now());
			db.save(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(book);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Book>> getAll() {
		List<Book> books = (List<Book>) db.findAll();
		try {
			if (books.size() == 0) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(books);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") int id) {
		Book book = db.findById(id);
		try {
			if (book.getName() == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(book);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		try {
			db.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Book> update(@PathVariable("id") int id, @RequestBody Book book) {
		try {
			if (id != book.getID()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		book.setDate(LocalDate.now());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(db.save(book));
	}
}
