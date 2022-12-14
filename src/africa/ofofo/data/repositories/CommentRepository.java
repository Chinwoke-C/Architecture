package africa.ofofo.data.repositories;

import africa.ofofo.data.models.Comment;


import java.util.List;

public interface CommentRepository  {
    Comment write(Comment comment);
    Comment findById(int id);
    List<Comment> findAllComments();
    long count();
    void deleteCommentById(int id);
}
