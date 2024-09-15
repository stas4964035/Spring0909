package k44.hw2_2.service;

import k44.hw2_2.model.Book;

import java.util.List;


public interface BookService {
    void addBook(Book book);
    List<Book> getBooks();
    Book getBook(int id);
    boolean updateBook(Book book, int id);
    boolean deleteBook(int id);
}
