package com.example.facebookdemo.service;

import com.example.facebookdemo.entity.Blog;
import com.example.facebookdemo.entity.User;
import com.example.facebookdemo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    public void saveBlog(Blog blog){
        blogRepository.save(blog);
    }
public List<Blog> getAllBlog(){
        return blogRepository.findAll();
}

}
