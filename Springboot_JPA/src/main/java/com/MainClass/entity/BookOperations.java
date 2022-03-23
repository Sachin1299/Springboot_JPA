package com.MainClass.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookOperations extends CrudRepository<Book, Integer> {

	public Book findById(int ID);

	
}
