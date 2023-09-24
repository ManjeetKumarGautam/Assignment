package com.example.Job.controller;

import com.example.Job.model.Job;
import com.example.Job.model.Type;
import com.example.Job.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobService jobService;

    @PostMapping("jobs")
    public String addJobs(@RequestBody @Valid List<Job> jobList){
        return jobService.addJobs(jobList);
    }

    @GetMapping("jobs")
    public List<Job> getJobs(){
        return jobService.getJobs();
    }

    @GetMapping("jobs/title/{title}")
    public List<Job> getJobByTitle(@PathVariable String title){
        return jobService.getJobByTitle(title);
    }

    @GetMapping("jobs/type/{jobType}")
    public List<Job> getJobByType(@PathVariable Type jobType){
        return jobService.getJobByType(jobType);
    }

    @GetMapping("jobs/title/{title}/salary/{salary}")
    public List<Job> getJobByTitleAndSalary(@PathVariable String title,@PathVariable Double salary){
        return jobService.getJobByTitleAndSalary(title,salary);
    }

    @GetMapping("jobs/salary/{salary}")
    public List<Job> getJobBySalary(@PathVariable Double salary){
        return jobService.getJobBySalary(salary);
    }

    @GetMapping("job/desc/{desc}")
    public List<Job> getJobByDescription(String desc){
        return jobService.getJobByDescription(desc);
    }

    @GetMapping("job/location/{location}")
    public List<Job> getJobByLocation(String location) {
        return jobService.getJobByLocation(location);
    }

    @PutMapping("job/id/{id}/salary/{salary}")
    public String updateSalaryById(@PathVariable Long id,@PathVariable Double salary){
        return jobService.updateSalaryById(id,salary);
    }

    @DeleteMapping("job/id/{id}")
    public String deleteJobById(@PathVariable Long id){
        return jobService.deleteJobById(id);
    }

    @DeleteMapping("job/type/{type}")
    public  String deleteByType(Type type){
        return jobService.deleteByType(type);
    }

}
