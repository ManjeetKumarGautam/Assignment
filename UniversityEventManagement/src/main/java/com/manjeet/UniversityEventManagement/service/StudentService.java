package com.manjeet.UniversityEventManagement.service;

import com.manjeet.UniversityEventManagement.model.Department;
import com.manjeet.UniversityEventManagement.model.Student;
import com.manjeet.UniversityEventManagement.repo.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public String addStudents(List<Student> stdList) {
        studentRepo.saveAll(stdList);
        return "Added...";
    }

    @Transactional
    public String updateStudentDepartmentById(Long id, String department) {
        studentRepo.updateStudentDepartment(id,department);
        return "Updated...";
    }

    public String deleteStudentById(Long id) {
        studentRepo.deleteById(id);
        return "Deleted...";
    }

    public List<Student> getStudents() {
        return (List<Student>)studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        Student student = studentRepo.findById(id).get();
        return student;
    }
}
