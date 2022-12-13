package services;

import data.models.Comment;
import data.models.Post;

import java.util.List;

public interface CommentService {
    void writeComment(String comment);
    void  updateComment(int id, String title, String body);
    void deleteComment(int id);
    Post viewComment(int id);
    List<Comment> viewAllComments();
}
