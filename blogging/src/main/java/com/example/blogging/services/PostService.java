package com.example.blogging.services;

import com.example.blogging.dto.PostDto;
import com.example.blogging.dto.UserDto;
import com.example.blogging.models.Post;
import com.example.blogging.repositories.PostRepository;
import com.example.blogging.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PostService {

    @Autowired private PostRepository postRepository;
    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;

    public PostDto createPost(MultipartFile file, String title, String subtitle,
                              String username) throws IOException {
        UserDto userDto = userService.getUserByUsername(username);
        Post post = new Post();
        post.setTitle(title);
        post.setSubtitle(subtitle);
        post.setAuthor(userRepository.findById(userDto.getId()).get());
        post.setFile(file, userService);
        Post savedPost = postRepository.save(post);
        PostDto createdPostDto = new PostDto();
        createdPostDto.setId(savedPost.getId());
        createdPostDto.setTitle(savedPost.getTitle());
        createdPostDto.setSubtitle(savedPost.getSubtitle());
        createdPostDto.setFile(savedPost.getFile(userService));
        return createdPostDto;
    }

    public List<PostDto> getAllPosts() throws IOException {
        List<Post> postsList =
            StreamSupport.stream(postRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : postsList) {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setSubtitle(post.getSubtitle());
            postDto.setFile(post.getFile(userService));
            postDtos.add(postDto);
        }
        return postDtos;
    }

    public PostDto getPostById(Long id) throws IOException {
        Post post = postRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Post not found"));
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setSubtitle(post.getSubtitle());
        postDto.setFile(post.getFile(userService));
        return postDto;
    }

    public PostDto updatePostById(Long id, MultipartFile file, String title,
                                  String subtitle)
        throws IOException {
        Post post = postRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Post not found"));
        if (title != null)
            post.setTitle(title);
        if (subtitle != null)
            post.setSubtitle(subtitle);
        if (file != null)
            post.setFile(file, userService);

        Post savedPost = postRepository.save(post);
        PostDto updatedPostDto = new PostDto();
        updatedPostDto.setId(savedPost.getId());
        updatedPostDto.setTitle(savedPost.getTitle());
        updatedPostDto.setSubtitle(savedPost.getSubtitle());
        updatedPostDto.setFile(savedPost.getFile(userService));
        return updatedPostDto;
    }

    public void deletePostById(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Post not found");
        }
    }
}
