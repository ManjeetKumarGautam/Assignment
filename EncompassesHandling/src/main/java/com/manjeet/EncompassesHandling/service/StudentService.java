package com.manjeet.EncompassesHandling.service;

import com.manjeet.EncompassesHandling.model.Student;
import com.manjeet.EncompassesHandling.repo.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public String addStudent(Student std) {
        studentRepo.save(std);
        return "Added new Student...";
    }

    public Student getStudent(String id) {
        return studentRepo.findById(id).get();
    }

    @Transactional
    public String updateStudent(String id, String columnName, String val) {
        if(studentRepo.existsById(id)){
            if(columnName.equals("name")){
                studentRepo.updateName(id,val);
            }
            else if(columnName.equals("age")){
                studentRepo.updateAge(id,val);
            }
            else if(columnName.equals("phoneNumber")){
                studentRepo.updatePhoneNumber(id,val);
            }
            else if (columnName.equals("branch")) {
                studentRepo.updateBranch(id,val);
            }
            else if(columnName.equals("department")){
                studentRepo.updateDepartment(id,val);
            }

            return "Update...";
        }
        return "Invalid id...";
    }

    public String deleteStudent(String id) {
        studentRepo.deleteById(id);
        return "Deleted...";
    }
}
