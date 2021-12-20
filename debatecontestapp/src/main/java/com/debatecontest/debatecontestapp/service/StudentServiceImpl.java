package com.debatecontest.debatecontestapp.service;

import java.util.List;
import java.util.Optional;

import com.debatecontest.debatecontestapp.entity.Student;
import com.debatecontest.debatecontestapp.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(int id) {
        Optional<Student> optional = repository.findById(id);
        Student student;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException("Unable to find student with the id " + id + ".");
        }
        return student;
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
