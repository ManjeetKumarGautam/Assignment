package com.manjeet.BasicInstagram.service;

import com.manjeet.BasicInstagram.model.Post;
import com.manjeet.BasicInstagram.model.dto.AuthInputDto;
import com.manjeet.BasicInstagram.repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    @Autowired
    TokenService tokenService;

    public String savePost(AuthInputDto authInfo, Post post) {

        if(tokenService.authenticate(authInfo)){
            post.getUser().setId(
                    tokenService.getUserIdByToken(
                            authInfo.getTokenValue()
                    )
            );
            postRepo.save(post);
            return "Post saved...";
        }
        return "Unauthenticated access...";
    }

    public Post getPosts(AuthInputDto authInfo,Integer id) {
        if(tokenService.authenticate(authInfo)){
            return postRepo.findById(id).get();
        }
        return null;
    }
}
