package ru.neirojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.neirojet.domain.Student;
import ru.neirojet.service.StudentService;

@Controller
public class IndexController {

    @Autowired
    StudentService service;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/students")
    public String students(Model model){
        model.addAttribute("students", service.findAll());
        return "students";
    }


    @RequestMapping("/student/{name}")
    public String student(@PathVariable String name, Model model) {
        model.addAttribute("student", service.findByName(name));
        return "student";
    }

    @RequestMapping("/student-new")
    public String studentNew(Model model) {
        model.addAttribute("student", service.createStudent());
        return "student-form";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String studentNew(Student student) {
        service.saveStudent(student);
        return "redirect:/student/"+student.getFirstName();
    }

    @RequestMapping("/student-edit/{name}")
    public String edit(@PathVariable String name, Model model) {
        model.addAttribute("student", service.findByName(name));
        return "student";
    }
    
}
