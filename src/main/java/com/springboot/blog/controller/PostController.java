package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return postService.getAllPosts(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id") long postId) {
        return ResponseEntity.ok(postService.updatePost(postDto, postId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long postId) {
        postService.deletePostById(postId);

        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }
}
