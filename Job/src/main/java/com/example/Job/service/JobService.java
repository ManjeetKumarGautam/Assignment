package com.example.Job.service;

import com.example.Job.model.Job;
import com.example.Job.model.Type;
import com.example.Job.repo.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobRepo jobRepo;

//    Crud methods
    public String addJobs(List<Job> jobList) {
        jobRepo.saveAll(jobList);
        return "New "+jobList.size()+" jobs were added...";
    }

    public List<Job> getJobs() {
        return (List<Job>)jobRepo.findAll();
    }

    public String deleteJobById(Long id){
        jobRepo.deleteById(id);
        return "Deleted...";
    }



//    Custom finder
    public List<Job> getJobByLocation(String location) {
        return jobRepo.findByLocation(location);
    }

    public List<Job> getJobByType(Type jobType) {
        return jobRepo.findByJobType(jobType);
    }

    public List<Job> getJobBySalary(Double salary) {
        return jobRepo.findBySalaryGreaterThanEqual(salary);
    }

    public List<Job> getJobByTitleAndSalary(String title, Double salary) {
        return jobRepo.findByTitleAndSalaryGreaterThanEqual(title,salary);
    }

//    Custom Query
    @Transactional
    public String updateSalaryById(Long id, Double salary) {
        jobRepo.updateSalaryById(id,salary);
        return "Salary updated...";
    }

    @Transactional
    public String deleteByType(Type jobType) {
        jobRepo.deleteJobByType(jobType);
        return "Deleted...";
    }

    @Transactional
    public List<Job> getJobByTitle(String title){
        return jobRepo.getJobByTitle(title);
    }

    @Transactional
    public List<Job> getJobByDescription(String desc){
        return jobRepo.getJobByDescription(desc);
    }

}
