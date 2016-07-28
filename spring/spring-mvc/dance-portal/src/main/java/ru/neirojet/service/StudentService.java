package ru.neirojet.service;

import ru.neirojet.domain.Student;

import java.util.List;

/**
 * Created by icetusk on 28.07.16.
 */
public interface StudentService {

    List<Student> findAll();

    Student findByName(String name);

    void saveStudent(Student s);

}
