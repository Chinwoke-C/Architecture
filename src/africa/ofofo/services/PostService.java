package africa.ofofo.services;

import africa.ofofo.data.models.Comment;
import africa.ofofo.dtos.requests.CreatePostRequest;
import africa.ofofo.data.models.Post;

import java.util.List;

public interface PostService {
    void createPost(CreatePostRequest createPostRequest);
    void  updatePost(int id, String title, String body);
    void deletePost(int id);
    Post viewPost(int id);
    List<Post> viewAll();
    void addComment(int postId, Comment comment);
}
