package com.manjeet.EncompassesHandling.service;

import com.manjeet.EncompassesHandling.model.Course;
import com.manjeet.EncompassesHandling.repo.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    ICourseRepo courseRepo;

    public String addCourse(Course course) {
        courseRepo.save(course);
        return "Added...";
    }

    public Course getCourse(String id) {
        return  courseRepo.findById(id).get();
    }

    public String updateCourse(String id, String columnName, String val) {
        if(courseRepo.existsById(id)){
            if(columnName.equals("title")){
                courseRepo.updateTitle(id,val);
            }
            else if(columnName.equals("description")){
                courseRepo.updateDescription(id,val);
            }
            else if (columnName.equals("duration")) {
                courseRepo.updateDuration(id,val);
            }

            return "Update...";
        }
        return "Invalid id...";
    }

    public String deleteCourse(String id) {
        courseRepo.deleteById(id);
        return "deleted...";
    }
}
