package io.book.rest.controller;

import io.book.rest.service.BookService;
import io.book.rest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{sku}")
    public Book getBook(@PathVariable String sku) {
        return bookService.getBookBySku(sku);
    }

    @GetMapping("/filter")
    public List<Book> getFilter(@RequestParam String type, @RequestParam String value) {
        return bookService.getBooksBy(type, value);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @PutMapping("/{sku}")
    public void updateProduct(@PathVariable String sku, @RequestBody Book book) {
        Book existingBook = bookService.getBookBySku(sku);
        if (existingBook != null) {
            book.setId(existingBook.getId());
            bookService.saveBook(book);
        }
    }

    @DeleteMapping("/{sku}")
    public void deleteBook(@PathVariable String sku) {
        bookService.deleteBook(sku);
    }

}
