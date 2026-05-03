package at.htlkaindorf.exa_505_studentlist.pojos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Student(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s, %s - %s", firstName, lastName, birthDate.format(DateTimeFormatter.ofPattern("dd.MMMyyyy")));
    }

    @Override
    public int compareTo(Student o) {
        if (this.firstName.equals(o.firstName)) {
            return this.lastName.compareTo(o.lastName);
        }

        return this.firstName.compareTo(o.firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lastName);
    }
}
