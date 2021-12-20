package com.debatecontest.debatecontestapp.controller;

import java.security.Principal;

import com.debatecontest.debatecontestapp.entity.Student;
import com.debatecontest.debatecontestapp.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/list")
    public String home(Model model) {
        model.addAttribute("Students", service.findAll());
        return "home";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("Student", new Student());
        return "form";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("Student", service.findById(id));
        return "form";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        service.deleteById(id);
        return "redirect:/list";
    }

    @PostMapping("/save")
    public String save(@RequestParam("id") int id, @RequestParam("name") String name,
            @RequestParam("department") String department, @RequestParam("country") String country) {
        Student student;

        if (id != 0) {
            student = service.findById(id);
            student.setName(name);
            student.setDepartment(department);
            student.setCountry(country);
        } else {
            student = new Student(name, department, country);
        }
        service.save(student);
        return "redirect:/list";
    }

    @RequestMapping(value = "/403")
    public ModelAndView accessDenied(Principal user) {
        ModelAndView modelAndView = new ModelAndView();

        if (user != null) {
            modelAndView.addObject("msg", "Hi " + user.getName() + ", you are not allowed to access this page.");
        } else {
            modelAndView.addObject("msg", "You are not allowed to access this page.");
        }
        modelAndView.setViewName("403");
        return modelAndView;
    }

}
