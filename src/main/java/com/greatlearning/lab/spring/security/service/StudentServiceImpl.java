package com.greatlearning.lab.spring.security.service;

import com.greatlearning.lab.spring.security.entities.Student;
import com.greatlearning.lab.spring.security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByID(int id) {
        return studentRepository.getByStudentId(id);
    }

    @Override
    public void saveStudent(Student newStudent) {
        studentRepository.save(newStudent);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteByStudentId(id);
    }
}