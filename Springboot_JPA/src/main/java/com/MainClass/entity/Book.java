package com.MainClass.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String Name;
	private String Language;
	private String Author;
	private int Price;
	@Column(name = "Entry_Date")
	private LocalDate Date;

	public LocalDate getDate() {
		return Date;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public Book(int iD, String name, String language, String author, int price, LocalDate date) {
		super();
		ID = iD;
		Name = name;
		Language = language;
		Author = author;
		Price = price;
		Date = date;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

}
