package k44.hw2_2.service;

import k44.hw2_2.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class BookServiceImpl implements BookService {
//    private static final String[] authors = {"Пушкин", "Лермонтов", "Толстой", "Бредбери", "Мартин", "Толкиен", "Страуструп", "Киркоров", "Бузова", "Инстасамка"};
//    private static final String[] firstPart = {"Лучший", "Худший", "Первый", "Последний", "Новый", "Старый", "Забытый", "Единый", "Королевский", "Базовый"};
//    private static final String[] lastPart = {"актер", "повар", "сказочник", "рассказ", "скрипт", "код", "принцип", "кот", "шут", "король", "президент", "слуга"};
//    private static final Random random = new Random();
//    public Book(String author, String title, Integer id) {
//        this.title = title;
//        this.author = author;
//    }
//    private static String createTitle(){
//        return firstPart[random.nextInt(firstPart.length)] + ' ' + lastPart[random.nextInt(lastPart.length)];
//    }
//    public static Book createBook(){
//        return new Book(authors[random.nextInt(authors.length)], createTitle());
//    }
    @Override
    public void addBook(Book book) {
        final int bookID = index.incrementAndGet();
        book.setId(bookID);
        books.put(bookID, book);
    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBook(int id) {
        return books.get(id);
    }

    @Override
    public boolean updateBook(Book book, int id) {
        if(books.containsKey(id)){
            book.setId(id);
            books.put(id, book);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        return books.remove(id) != null;
    }

    private static final Map<Integer, Book> books = new HashMap<>();
    private static final AtomicInteger index = new AtomicInteger();
}
