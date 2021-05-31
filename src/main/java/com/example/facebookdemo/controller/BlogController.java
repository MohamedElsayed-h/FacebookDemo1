package com.example.facebookdemo.controller;

import com.example.facebookdemo.entity.Blog;
import com.example.facebookdemo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;


    @GetMapping("/saveBlog")
    public String saveBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.saveBlog(blog);
        model.addAttribute("blogs", blogService.getAllBlog());
        return "blog";
    }
    @GetMapping("/Blogs")
    public String blogs( Model model) {

        model.addAttribute("blogs", blogService.getAllBlog());
        return "AllBlogs";
    }
   }
