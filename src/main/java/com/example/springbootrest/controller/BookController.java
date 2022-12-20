package com.example.springbootrest.controller;

import com.example.springbootrest.model.Book;
import com.example.springbootrest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@EntityScan("com.example.springbootrest.model")
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/book")
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/book/{barcode}")
    public ResponseEntity<Book> getBookByBarcode(@PathVariable(value = "barcode") long barcode) throws RuntimeException{
        Book book = bookRepository.findById(barcode).orElseThrow(()-> new RuntimeException("Book not found"));
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/book/{barcode}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "barcode") long barcode, @RequestBody Book newBookData)
            throws RuntimeException{
        Book book = bookRepository.findById(barcode).orElseThrow(()-> new RuntimeException("Book by barcode: " +
                barcode + " was not found"));
        book.setName(newBookData.getName());
        book.setAuthor(newBookData.getAuthor());
        book.setPrice(newBookData.getPrice());
        book.setQuantity(newBookData.getQuantity());
        bookRepository.save(book);
        return ResponseEntity.ok().body(book);
    }
}
