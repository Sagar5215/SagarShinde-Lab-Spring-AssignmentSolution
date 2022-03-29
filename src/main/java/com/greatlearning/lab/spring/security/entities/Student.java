package com.greatlearning.lab.spring.security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    private String name;

    private String department;

    private String country;

    public Student(String name, String department, String country) {
        this.name = name;
        this.department = department;
        this.country = country;
    }
}
