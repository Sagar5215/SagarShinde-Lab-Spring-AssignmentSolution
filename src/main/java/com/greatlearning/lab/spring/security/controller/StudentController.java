package com.greatlearning.lab.spring.security.controller;

import com.greatlearning.lab.spring.security.entities.Student;
import com.greatlearning.lab.spring.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("Students", students);
        return "student_list";
    }

    @RequestMapping("/showFormForAdd")
    public String ShowFormForAdd(Model model) {
        Student student = new Student();
        model.addAttribute("Student", student);
        return "student_form";
    }

    @RequestMapping("/showFormForUpdate")
    public String ShowFormForUpdate(@RequestParam("studentId") int id, Model model) {
        Student student = studentService.findStudentByID(id);
        model.addAttribute("Student", student);
        return "student_form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("id") int id, @RequestParam("name") String name,
                       @RequestParam("department") String department,
                       @RequestParam("country") String country) {
        Student student;
        if (id != 0) {
            student = studentService.findStudentByID(id);
            student.setName(name);
            student.setCountry(country);
            student.setDepartment(department);
        } else {
            student = new Student(name, department, country);
        }
        studentService.saveStudent(student);
        return "redirect:/students/list";
    }

    @RequestMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }

    @RequestMapping(value = "/403")
    public ModelAndView accessDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        model.setViewName("403");
        return model;
    }
}
