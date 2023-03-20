package ua.pupa.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty(message = "Field can`t be empty empty")
    @Size(max=50, message = "Book name can`t be longer than 50 characters")
    private String bookName;
    @NotEmpty(message = "Field can`t be empty empty")
    @Size(max=50, message = "Author name can`t be longer than 50 characters")
    private String authorName;
    @Min(value = 1900, message = "Year should be greater than 0")
    private int releaseYear;

    private Integer usedBy;

    public Book(int id, String bookName, String authorName, int releaseYear, int usedBy) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.releaseYear = releaseYear;
        this.usedBy = usedBy;
    }

    public Book(int id, String bookName, String authorName, int releaseYear) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.releaseYear = releaseYear;
    }

    public Book() {
    }

    public Integer getUsedBy() {
        return usedBy;
    }

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setUsedBy(Integer usedBy) {
        this.usedBy = usedBy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
