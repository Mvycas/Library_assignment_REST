package com.example.springbootrest.controller;

import com.example.springbootrest.model.Book;
import com.example.springbootrest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class PriceController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/price/{barcode}")
    public ResponseEntity<Double> getBookByBarcode(@PathVariable(value = "barcode") long barcode) throws RuntimeException{
        Book book = bookRepository.findById(barcode).orElseThrow(()-> new RuntimeException("Book not found"));
        return ResponseEntity.ok().body(book.getPrice() * book.getQuantity());
    }

}
