package africa.ofofo.controllers;

import africa.ofofo.dtos.requests.CreatePostRequest;
import africa.ofofo.services.PostService;
import africa.ofofo.services.PostServiceImpl;
import africa.ofofo.data.models.Post;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private PostService postService = new PostServiceImpl();
    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequest createPostRequest){
        postService.createPost(createPostRequest);
        return "Successful";
    }

    @GetMapping("/post/{postId}")
    public Post viewPost(@PathVariable int postId){
        return postService.viewPost(postId);
    }
}
