package com.example.URLHit.repo;

import com.example.URLHit.model.URLHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class URLHitRepo {

    @Autowired
    private Map<String, Integer> urlHitMap;

    public Map<String, Integer> getUrlHitMap() {
        return urlHitMap;
    }
}
