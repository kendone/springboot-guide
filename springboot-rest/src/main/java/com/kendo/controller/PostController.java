package com.kendo.controller;

import com.kendo.domain.Post;
import com.kendo.repositories.CommentRepository;
import com.kendo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kendone
 */
@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("")
    public List<Post> list() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post get(@PathVariable("id") Integer id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("没有此记录"));
    }

    @PutMapping("/{id")
    public Post update(@PathVariable("id") Integer id, @RequestBody Post post) throws Throwable {
        postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("没有此记录"));
        return postRepository.save(post);
    }

    @DeleteMapping("/{id")
    public void delete(@PathVariable("id") Integer id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("没有此记录"));
        postRepository.deleteById(post.getId());
    }
}
