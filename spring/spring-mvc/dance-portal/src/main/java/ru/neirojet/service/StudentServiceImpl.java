package ru.neirojet.service;

import org.springframework.stereotype.Component;
import ru.neirojet.domain.Student;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findByName(String name) {
        return null;
    }

    @Override
    public void saveStudent(Student s) {

    }
}
