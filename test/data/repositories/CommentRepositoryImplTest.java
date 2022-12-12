package data.repositories;

import data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommentRepositoryImplTest {
    CommentRepository commentRepo;
    @BeforeEach
    void setUp() {
        commentRepo = new CommentRepositoryImpl();
    }
    @Test
    public void saveNewComment_OneCommentSavedTest(){
        Comment comment = new Comment();
        comment.setComment("Cool write-up");
        commentRepo.write(comment);
        assertEquals(1,commentRepo.count());
    }
    @Test
    public void saveNewComment_findByIdReturnsSavedCommentTest(){
        Comment comment = new Comment();
        comment.setComment("Cool write-up");
        commentRepo.write(comment);
        assertEquals(1,commentRepo.count());

        Comment savedComment = commentRepo.findById(1);
       assertEquals(comment, savedComment);
       Comment comment2 = new Comment();
       commentRepo.write(comment2);
       assertEquals(comment2,commentRepo.findById(2));
    }
    @Test
    public void saveNewPost_updatePost_countIsOneTest(){
        Comment comment = new Comment();
        comment.setComment("Cool write-up");
        commentRepo.write(comment);

        Comment updatedComment = new Comment();
        updatedComment.setId(1);
        updatedComment.setComment("You suck");
        commentRepo.write(updatedComment);
        assertEquals(1,commentRepo.count());
    }
    @Test
    public void deleteItem_countIsZeroTest(){}
}