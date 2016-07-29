package ru.neirojet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.neirojet.domain.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static List<Student> students = new ArrayList<>();

    @Qualifier("studentFactoryFileImpl")
    @Autowired
    StudentFactory factory;

    @Qualifier("studentFactoryRestImpl")
    @Autowired
    StudentFactory restFactory;

    @PostConstruct
    public void init() {
        for(int i=0; i < 5; i++) {
            students.add(factory.createStudent());
        }
    }

    @Override
    public Student createStudent() {
        return restFactory.createStudent();
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findByName(String name) {
        for(Student s: students) {
            if(s.getFirstName().equalsIgnoreCase(name) || s.getLastName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void saveStudent(Student student) {
        students.remove(student);
        students.add(student);
    }
}
