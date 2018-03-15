package com.example.spring.boot.web;

import com.example.spring.boot.dao.entity.Blog;
import com.example.spring.boot.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public Flux<Blog> findAll() {
        return blogService.findAll();
    }

    @GetMapping("/find")
    public Flux<Blog> findByTitle(@RequestParam String blogTitle) {
        return blogService.findByTitle(blogTitle);
    }

    @GetMapping("/{id}")
    public Mono<Blog> findOne(@PathVariable String id) {
        return blogService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Blog> create(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable String id) {
        return blogService.delete(id);
    }

    @PutMapping("/{id}")
    public Mono<Blog> updateBook(@RequestBody Blog blog, @PathVariable String id) {
        return blogService.updateBlog(blog, id);
    }
}
