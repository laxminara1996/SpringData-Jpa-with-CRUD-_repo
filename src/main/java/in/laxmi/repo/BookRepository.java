package in.laxmi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.laxmi.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
public List<Book> findByBookPriceGreaterThanEqual(Double bookPrice);
public List<Book> findByBookPriceLessThanEqual(Double bookPrice);
public List<Book> findByBookName(String bookName);
@Query(value="select * from Book", nativeQuery = true)
public List<Book> getAllBooks();
@Query("from Book")
public List<Book> getBooks();
}
