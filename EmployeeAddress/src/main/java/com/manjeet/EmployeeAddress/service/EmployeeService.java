package com.manjeet.EmployeeAddress.service;

import com.manjeet.EmployeeAddress.model.Employee;
import com.manjeet.EmployeeAddress.repo.IEmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepo employeeRepo;

    public List<Employee> getEmployees() {
        return (List<Employee>)employeeRepo.findAll();
    }

    public Employee getEmployee(Long id) {
        return employeeRepo.findById(id).get();
    }

    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Added...";
    }

    @Transactional
    public String updateEmployee(Long id, String columnName, String val) {
        if(employeeRepo.existsById(id)){
            if(columnName.equals("firstName")){
                employeeRepo.updateFirstName(val,id);
                return columnName+" updated...";
            }
            else if(columnName.equals("lastName")){
                employeeRepo.updateLastName(val,id);
                return columnName+" updated...";
            }
            else if(columnName.equals("addressId")){
                employeeRepo.updateAddressId(Long.parseLong(val),id);
                return columnName+" updated...";
            }
            else {
                return "Column name not found...";
            }

        }
        return "Invalid Id";
    }

    public String deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
        return "Deleted...";
    }
}
