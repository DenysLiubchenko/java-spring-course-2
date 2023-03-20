package ua.pupa.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.pupa.models.Book;
import ua.pupa.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return new ArrayList<>(jdbcTemplate.query("SELECT * FROM people", new BeanPropertyRowMapper<>(Person.class)));
    }
    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM people where id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }
    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO people(personName, birthYear) values (?,?)", person.getPersonName(),
                person.getBirthYear());
    }
    public void update(int id, Person person){
        jdbcTemplate.update("UPDATE people set personName=?, birthYear=? where id = ?", person.getPersonName(),
                person.getBirthYear(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE from people where id = ?", id);
    }

    public Optional<Person> show(String name) {
        return jdbcTemplate.query("SELECT * FROM people where personName = ?", new Object[]{name},
                new BeanPropertyRowMapper(Person.class)).stream().findAny();
    }
    public List<Book> getBooks (int id){
        return jdbcTemplate.query("SELECT * FROM books where usedBy=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
}
