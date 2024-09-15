package k44.hw2_2.controller;

import k44.hw2_2.model.Book;
import k44.hw2_2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/")
    public String hello(){
        return "Hello user!";
    }

    @PostMapping("/books")
    public ResponseEntity<?> create(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> read(){
        final List<Book> books = bookService.getBooks();
        return books != null && !books.isEmpty() ?
                new ResponseEntity<>(books, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> read(@PathVariable(name = "id") int id){
        final Book book = bookService.getBook(id);
        return book != null ?
                new ResponseEntity<>(book, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("books/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Book book){
        final boolean updated = bookService.updateBook(book, id);
        return updated ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = bookService.deleteBook(id);
        return deleted ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }

}
