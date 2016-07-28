package ru.neirojet.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.neirojet.domain.Student;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    private static List<Student> students = new ArrayList<>();


    @PostConstruct
    public void init() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(
                "https://randomuser.me/api/",
                String.class);

        System.out.println(response);

        Student s = new Student();
        s.setBirthDate(LocalDate.of(1984, 5, 23));
        s.setName("Vasya");
        s.setSecondName("Pupking");
        students.add(s);

        s = new Student();
        s.setBirthDate(LocalDate.of(1983, 4, 12));
        s.setName("Mariya");
        s.setSecondName("Tarasova");
        students.add(s);

        s = new Student();
        s.setBirthDate(LocalDate.of(1980, 2, 1));
        s.setName("Chuck");
        s.setSecondName("Norris");
        students.add(s);


    }


    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findByName(String name) {
        return null;
    }

    @Override
    public void saveStudent(Student s) {

    }
}
