package io.book.rest.repository;

import io.book.rest.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Book findBySku(String sku);
    List<Book> findByName(String name);
    List<Book> findByAuthor(String author);
}
