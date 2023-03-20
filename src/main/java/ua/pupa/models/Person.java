package ua.pupa.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "Field can`t be empty empty")
    @Size(max=50, message = "Name can`t be longer than 50 characters")
    private String personName;
    @Min(value = 1900, message = "Birth year should be greater than 1900")
    private int birthYear;

    public Person(int id, String personName, int birthYear) {
        this.id = id;
        this.personName = personName;
        this.birthYear = birthYear;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getPersonName() {
        return personName;
    }
    public int getBirthYear() {
        return birthYear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
