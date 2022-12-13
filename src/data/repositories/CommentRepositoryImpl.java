package data.repositories;

import data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{
    private int idCount;
    private List<Comment> commentDb = new ArrayList<>();
    @Override
    public Comment write(Comment comment) {
        if (comment.getId() != 0) update(comment);
        else {
            commentDb.add(comment);
            idCount++;
            comment.setId(idCount);
        }
        return comment;
    }

    private void update(Comment comment) {
        //first find the original
        Comment savedComment = findById(comment.getId());
        //set new details
        savedComment.setComment(comment.getComment());

    }

    @Override
    public Comment findById(int id) {
        for (Comment comment:commentDb) {
            if (comment.getId()==id){
                return comment;
            }
        }
        return null;
    }

    @Override
    public List<Comment> findAllComments() {
        return null;
    }

    @Override
    public long count() {
        return commentDb.size();
    }

    @Override
    public void deleteCommentById(int id) {
        for (Comment comment:commentDb) {
            if (comment.getId()==id){
                commentDb.remove(comment);
            break;
            }
        }

    }
}
