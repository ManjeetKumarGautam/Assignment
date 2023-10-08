package com.manjeet.EncompassesHandling.Controller;

import com.manjeet.EncompassesHandling.model.Student;
import com.manjeet.EncompassesHandling.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public String addStudent(@RequestBody Student std){
        return studentService.addStudent(std);
    }

    @GetMapping("/id/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudent(id);
    }

    @PutMapping("/id/{id}")
    public String updateStudent(@PathVariable String id,@RequestParam String columnName,@RequestParam String val){
        return studentService.updateStudent(id,columnName,val);
    }

    @DeleteMapping("/id/{id}")
    public  String deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }
}
