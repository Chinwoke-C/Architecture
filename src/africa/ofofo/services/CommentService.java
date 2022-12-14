package africa.ofofo.services;

import africa.ofofo.data.models.Comment;
import africa.ofofo.data.models.Post;
import africa.ofofo.dtos.requests.CreateCommentRequest;

import java.util.List;

public interface CommentService {
    void createComment(CreateCommentRequest createCommentRequest);
//    void  updateComment(int id, String title, String body);
//    void deleteComment(int id);
//    Post viewComment(int id);
//    List<Comment> viewAllComments();
}
