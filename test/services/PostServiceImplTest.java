package services;

import data.models.Post;
import dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {
private PostService postService;
    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
    }
    @Test
    public void createPostTest(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAll().size());
    }
    @Test
    public void viewPost(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAll().size());

        Post post = postService.viewPost(1);
        assertEquals("New Post", post.getTitle());
        assertEquals("Egusi is my best soup", post.getBody());
    }
}