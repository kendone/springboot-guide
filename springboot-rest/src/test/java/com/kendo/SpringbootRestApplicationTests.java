package com.kendo;

import com.kendo.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertNotNull;

/**
 * @author kendone
 */
@SpringBootTest
public class SpringbootRestApplicationTests {

    private static final String ROOT_URL = "http://localhost:8080";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void findAll() {
        ResponseEntity<Post[]> responseEntity =
                restTemplate.getForEntity(ROOT_URL + "/posts", Post[].class);
        List<Post> posts = Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
        assertNotNull(posts);
    }
}
