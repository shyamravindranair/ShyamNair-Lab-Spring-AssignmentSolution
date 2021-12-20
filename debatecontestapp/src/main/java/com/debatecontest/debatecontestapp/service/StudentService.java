package com.debatecontest.debatecontestapp.service;

import java.util.List;

import com.debatecontest.debatecontestapp.entity.Student;

public interface StudentService {

    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void deleteById(int id);

}
