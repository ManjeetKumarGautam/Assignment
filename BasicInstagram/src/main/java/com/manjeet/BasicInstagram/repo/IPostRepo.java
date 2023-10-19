package com.manjeet.BasicInstagram.repo;

import com.manjeet.BasicInstagram.model.AuthToken;
import com.manjeet.BasicInstagram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {

    Object findAllByUserEmail(String email);

    Object findByUserEmail(String email);
}
