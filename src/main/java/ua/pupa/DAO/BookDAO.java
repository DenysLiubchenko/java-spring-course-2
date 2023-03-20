package ua.pupa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.pupa.models.Book;
import ua.pupa.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return new ArrayList<>(jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class)));
    }
    public Book show(int id){
        return jdbcTemplate.query("SELECT * FROM books where id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }
    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO books(bookName, authorName, releaseYear) values (?,?,?)", book.getBookName(),
                book.getAuthorName(), book.getReleaseYear());
    }
    public void update(int id, Book book){
        jdbcTemplate.update("UPDATE books set bookName=?, authorName=?, releaseYear=? where id = ?", book.getBookName(),
                book.getAuthorName(), book.getReleaseYear(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE from books where id = ?", id);
    }
    public void setBookToPerson(int personId, int bookId){
        jdbcTemplate.update("UPDATE books set usedBy=? where id = ?", personId, bookId);
    }
    public Person getPerson(Book book) {
        return jdbcTemplate.query("SELECT * FROM people where id =?", new Object[]{book.getUsedBy()},
                        new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }
    public void freeBook(int bookId){
        jdbcTemplate.update("UPDATE books set usedBy=NULL where id = ?", bookId);
    }

    public List<Person> getPeople() {
        return new ArrayList<>(jdbcTemplate.query("SELECT * FROM people", new BeanPropertyRowMapper<>(Person.class)));
    }
}
