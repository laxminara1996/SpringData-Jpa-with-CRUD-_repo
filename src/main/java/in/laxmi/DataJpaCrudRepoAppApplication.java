package in.laxmi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.SystemPropertyUtils;

import in.laxmi.entity.Book;
import in.laxmi.repo.BookRepository;

@SpringBootApplication
public class DataJpaCrudRepoAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(DataJpaCrudRepoAppApplication.class, args);
	System.out.println(ctxt.getClass().getName());
	BookRepository rep = ctxt.getBean(BookRepository.class);
	//save and saveAll methods
	System.out.println("repo"+rep.getClass().getName());
	
	Book b =  new Book();
	b.setBookId(2);
	b.setBookName("java");
	b.setBookPrice(700.00);
	Book b1 =  new Book();
	b1.setBookId(3);
	b1.setBookName("oracle");
	b1.setBookPrice(400.00);
	rep.saveAll(Arrays.asList(b,b1));
	
	//ExistById
	
	boolean status = rep.existsById(3);
     System.out.println("Record Presence::"+status);
     
	//count method
     
     int count =  (int) rep.count();
     System.out.println("records count is:: "+rep.count());
     
    // findById
     Optional<Book> findById = rep.findById(1);
     if(findById.isPresent()){
    	 System.out.println("find bi id ::"+findById.get());
     }else {
    	 System.out.println("not found");
     }
     
     //findByAllId
     Iterable<Book> findAllById = rep.findAllById(Arrays.asList(1,2));
     for(Book fb: findAllById) {
    	 System.out.println(fb);
     }
     
     //findAll
    Iterable<Book> books =  rep.findAll();
    for(Book bk:books) {
    	System.out.println(bk);
    }
    
    //deleteById
     rep.deleteById(1);
    
    if(rep.existsById(1)) {
    	rep.deleteById(1);	
    }else {
    	System.out.println("no record found");
    }
	
	//findBy method-->used to perform select operation and filter by using non-primary keys
	List<Book> bookDet = rep.findByBookPriceGreaterThanEqual(300.00);
	for(Book bd:bookDet) {
		System.out.println(bd);
	}
	//findByBookName
	List<Book> bookNames = rep.findByBookName("java");
	for(Book bn:bookNames) {
		System.out.println(bn);
	}
	//get books by Native SQL QUERY
	List<Book> allBooks = rep.getAllBooks();
    for(Book a:allBooks) {
    	System.out.println(a);
    }
	//get books by Native HQL QUERY
    List<Book> booksdata = rep.getBooks();
    for(Book all:booksdata) {
    	System.out.println(all);
    }
     
    
    
	}

}
