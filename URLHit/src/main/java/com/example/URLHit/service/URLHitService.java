package com.example.URLHit.service;

import com.example.URLHit.model.URLHit;
import com.example.URLHit.repo.URLHitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class URLHitService {

    @Autowired
    URLHitRepo urlHitRepo;

    public String addUrlHit(String username){


        urlHitRepo.getUrlHitMap().put(
                username,
                urlHitRepo.getUrlHitMap().getOrDefault(username,0)+1
        );
        return  username+" hit";
    }

    public URLHit getUrlHit(String userName){
        URLHit urlHit=new URLHit();
        urlHit.setUsername(userName);
        urlHit.setCount(urlHitRepo.getUrlHitMap().get(userName));

        return  urlHit;
    }

    public String getHitCount() {
        int count=0;
        for (String str : urlHitRepo.getUrlHitMap().keySet()){
            count+= urlHitRepo.getUrlHitMap().get(str);
        }
        return "Total Url Hit : " + count;
    }

    public String getVisitors() {
        return "Visitors : "+ urlHitRepo.getUrlHitMap().size();
    }
}
