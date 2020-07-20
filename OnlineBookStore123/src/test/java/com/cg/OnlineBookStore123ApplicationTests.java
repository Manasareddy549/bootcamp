package com.cg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
//import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.dao.BookDao;
import com.cg.dao.CategoryDao;
import com.cg.entity.Book;
import com.cg.entity.Category;
import com.cg.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OnlineBookStore123ApplicationTests {

	@Autowired
	private AdminService as;
	
	@MockBean
	CategoryDao crep;
	@MockBean
	BookDao bd;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addCategoryTest() {
		Category c=new Category(101,"Horror",null);
		as.addCategory(c);
		assertEquals("Horror",c.getCategoryName());
	}
	
	  @Test
	  public void addBookTest(){
	  Book b=new Book(null, 201,"The Subtle art","siri","breathtaking experience",1123,200, null, null);
	  as.addBook(b);
	  assertEquals("The Subtle art",b.getTitle());
	  }
	  
//	  @Test
//	public void removeBookTest(){ 
//		Book b=new Book(201,"The Subtle art","siri","breathtaking experience",1123,200);
//		bd.findById(201);
//		crep.delete(b);
//        verify(crep,times(1)).delete(b);
//	}
	
	@Test
	public void listOfBookTest() {
		List<Book> bookinfo=new ArrayList<Book>();
		bookinfo.add(new Book(null, 110,"The Subtle art","siri","breathtaking experience",1123,200, null, null));
		bookinfo.add(new Book(null, 111,"The Subtle","siriiii","breathtaking experience",1124,200, null, null));
		when(bd.findAll()).thenReturn(bookinfo);
		List<Book> result = as.listOfBook();
		assertEquals(2, result.size());
		
	}
	@Test
	public void getAllCategoryTest(){
			List<Category> CategoryList = new ArrayList<Category>();
		    CategoryList.add(new Category(201,"Horror",null));
			CategoryList.add(new Category(202,"Thriller ",null));
			when(crep.findAll()).thenReturn(CategoryList);
			
			List<Category> result = as.getAllCategory();
			assertEquals(2, result.size());
		}
	  
	@Test
	public void UpdateCategoryTest() {
		Category c=new Category(101,"Horror",null);
		c.setCategoryName("fantasy");
		as.UpdateCategory(c);
		assertEquals("fantasy",c.getCategoryName());
	}
	
	 @Test
	 public void removeCategoryTest(){
	 Category c=new Category(101,"horror",null);
	 crep.delete(c);
        verify(crep,times(1)).delete(c);
	 }
	 
	 @Test
	 public void updateBookTest() throws java.text.ParseException{
			Book b= new Book(null, 201,"The Subtle art","siri","breathtaking experience",1123,200, null, null);
			bd.findById(201);
			bd.save(b);
			verify(bd,Mockito.times(1)).save(b);
	 }
	
	
	

}