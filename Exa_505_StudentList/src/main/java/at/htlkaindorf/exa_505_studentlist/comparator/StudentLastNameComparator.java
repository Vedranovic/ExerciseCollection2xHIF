package at.htlkaindorf.exa_505_studentlist.comparator;

import at.htlkaindorf.exa_505_studentlist.pojos.Student;

import java.util.Comparator;

public class StudentLastNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getLastName().compareTo(o1.getLastName());
    }
}
