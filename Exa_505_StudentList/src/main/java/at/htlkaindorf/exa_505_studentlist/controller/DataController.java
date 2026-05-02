package at.htlkaindorf.exa_505_studentlist.controller;

import at.htlkaindorf.exa_505_studentlist.exception.DuplicateStudentException;
import at.htlkaindorf.exa_505_studentlist.pojos.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;

public class DataController {
    private ObservableList<Student> students;

    public DataController() {
        this.students = FXCollections.observableArrayList();
    }

    public void deleteStudent(int index) {
        students.remove(index);
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            FXCollections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
            });
        } else {
            throw new DuplicateStudentException(student.toString() + "is already in the list!");
        }
    }

    public ObservableList<Student> getStudents() {
        return students;
    }
}
