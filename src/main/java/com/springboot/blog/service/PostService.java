package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

//    List<PostDto> getAllPosts(int pageNo, int pageSize);

    PostDto getPostById(long postId);

    PostDto updatePost(PostDto postDto, long postId);

    void deletePostById(long postId);

}
