package com.greatlearning.lab.spring.security.service;

import com.greatlearning.lab.spring.security.entities.Role;
import com.greatlearning.lab.spring.security.entities.Student;
import com.greatlearning.lab.spring.security.entities.User;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents();

    Student findStudentByID(int id);

    void deleteStudent(int id);

    void saveStudent(Student newStudent);
}
