package com.cg.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="category1")
public class Category {
	@Id   
	@Column(length=12)   
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int CategoryId;
	@Value("Horror")
	@Column(length=50)
	public String CategoryName;
	
	@OneToMany(mappedBy="category")
	private List<Book> books = new ArrayList<Book>();

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	@JsonIgnore
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public Category() {
		super();
	}

	public Category(int categoryId, String categoryName, List<Book> books) {
		
		CategoryId = categoryId;
		CategoryName = categoryName;
		this.books = books;
	}
	
	
	

}