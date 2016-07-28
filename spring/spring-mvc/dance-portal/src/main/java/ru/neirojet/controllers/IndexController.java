package ru.neirojet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

        model.addAttribute(service.findAll());

        return "students";
    }
}
