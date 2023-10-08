package com.manjeet.EncompassesHandling.Controller;

import com.manjeet.EncompassesHandling.model.Book;
import com.manjeet.EncompassesHandling.model.Course;
import com.manjeet.EncompassesHandling.model.Student;
import com.manjeet.EncompassesHandling.service.BookService;
import com.manjeet.EncompassesHandling.service.CourseService;
import com.manjeet.EncompassesHandling.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping("/id/{id}")
    public Course getCourseById(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @PutMapping("/id/{id}")
    public String updateCourse(@PathVariable String id,@RequestParam String columnName,@RequestParam String val){
        return courseService.updateCourse(id,columnName,val);
    }

    @DeleteMapping("/id/{id}")
    public  String deleteCourse(@PathVariable String id){
        return courseService.deleteCourse(id);
    }


}
