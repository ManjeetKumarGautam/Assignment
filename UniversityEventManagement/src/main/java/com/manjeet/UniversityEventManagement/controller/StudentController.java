package com.manjeet.UniversityEventManagement.controller;

import com.manjeet.UniversityEventManagement.model.Department;
import com.manjeet.UniversityEventManagement.model.Student;
import com.manjeet.UniversityEventManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Validated
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("students")
    public String addStudents(@RequestBody @Valid List<Student> stdList){
        return studentService.addStudents(stdList);
    }

    @PutMapping("student/id/{id}/department/{department}")
    public String updateStudentDepartmentById(@PathVariable Long id, @PathVariable String department){
        return  studentService.updateStudentDepartmentById(id,department);
    }

    @DeleteMapping("student/id/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return  studentService.deleteStudentById(id);
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("student/id/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
