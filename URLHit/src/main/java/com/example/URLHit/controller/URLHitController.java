package com.example.URLHit.controller;

import com.example.URLHit.model.URLHit;
import com.example.URLHit.service.URLHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/visitor-count-app")
public class URLHitController {
    @Autowired
    URLHitService urlHitService;

    @PostMapping("/username/{username}")
    public String addUrlHit(@PathVariable String username){
        return urlHitService.addUrlHit(username);
    }

    @GetMapping("/username/{userName}/count")
    public URLHit getUrlHitCount(@PathVariable String userName) {
        return urlHitService.getUrlHit(userName);
    }

    @GetMapping("/count")
    public String getHitCount(){
        return urlHitService.getHitCount();
    }

    @GetMapping("/visitors")
    public  String getVisitors(){
        return urlHitService.getVisitors();
    }
}
