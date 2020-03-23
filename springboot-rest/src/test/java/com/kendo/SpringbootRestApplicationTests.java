package com.kendo;

import com.kendo.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author kendone
 */
@SpringBootTest
public class SpringbootRestApplicationTests {

    private static final String ROOT_URL = "http://localhost/rest";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getAll() {
        ResponseEntity<Post[]> responseEntity =
                restTemplate.getForEntity(ROOT_URL + "/posts", Post[].class);
        List<Post> posts = Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
        assertNotNull(posts);
    }

    @Test
    public void getById() {
        Post post = restTemplate.getForObject(ROOT_URL + "/posts/1", Post.class);
        assertNotNull(post);
    }

    @Test
    public void create() {
        Post post = new Post();
        post.setTitle("好好学习Spring Boot");
        post.setContent("Spring Boot 非常易用");
        post.setCreatedOn(new Date());

        ResponseEntity<Post> postResponseEntity = restTemplate.postForEntity(ROOT_URL + "/posts", post, Post.class);
        assertNotNull(postResponseEntity);
        assertNotNull(postResponseEntity.getBody());
    }

    @Test
    public void update() {
        Post post = restTemplate.getForObject(ROOT_URL + "/posts/4", Post.class);
        assertNotNull(post);
        post.setContent("Spring Boot意气风发");
        post.setUpdatedOn(new Date());

        restTemplate.put(ROOT_URL + "/posts/4", post);
        Post updatedPost = restTemplate.getForObject(ROOT_URL + "/posts/4", Post.class);
        assertNotNull(updatedPost);
    }

    @Test
    public void delete() {
        Post post = restTemplate.getForObject(ROOT_URL + "/posts/4", Post.class);
        assertNotNull(post);
        restTemplate.delete(ROOT_URL + "/posts/4");
        post = restTemplate.getForObject(ROOT_URL + "/posts/4", Post.class);
        assertNull(post);
    }
}
