package com.debatecontest.debatecontestapp.repository;

import com.debatecontest.debatecontestapp.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
