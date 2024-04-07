package io.book.rest.service;

import io.book.rest.model.Book;
import io.book.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookBySku(String sku) {
        return bookRepository.findBySku(sku);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(String sku) {
        Book book = bookRepository.findBySku(sku);
        bookRepository.delete(book);
    }

    public List<Book> getBooksBy(String type, String value) {
        List<Book> books = null;

        if("name".equals(type)) {
            books = bookRepository.findByName(value);
        }
        else if("author".equals(type)) {
            books = bookRepository.findByAuthor(value);
        }
        else if("sku".equals(type)) {
            Book book = bookRepository.findBySku(value);
            List<Book> list = new ArrayList<>();
            list.add(book);
            books = list;
        }

        return books;
    }
}
