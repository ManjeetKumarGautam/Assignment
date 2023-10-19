package com.manjeet.BasicInstagram.controller;

import com.manjeet.BasicInstagram.model.Post;
import com.manjeet.BasicInstagram.model.dto.AuthInputDto;
import com.manjeet.BasicInstagram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("userPost")
    public String savePost(@RequestBody AuthInputDto authInfo, @RequestBody Post post){
        return postService.savePost(authInfo,post);
    }

    @GetMapping("userPost/{id}")
    public Post getPosts(@RequestBody AuthInputDto authInfo, @PathVariable Integer id){
        return postService.getPosts(authInfo,id);
    }
}
