package data.repositories;

import africa.ofofo.data.models.Comment;
import africa.ofofo.data.repositories.CommentRepository;
import africa.ofofo.data.repositories.CommentRepositoryImpl;
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
    public void deleteItem_countIsZeroTest(){
        Comment comment = new Comment();
        comment.setComment("Cool write-up");
        commentRepo.write(comment);
        assertEquals(1,commentRepo.count());
        Comment comment2 = new Comment();
        commentRepo.write(comment2);
        Comment comment3= new Comment();
        commentRepo.write(comment3);
        Comment comment4 = new Comment();
        commentRepo.write(comment4);

        commentRepo.deleteCommentById(4);
        assertEquals(3,commentRepo.count());
    }
    @Test
    public void delete_Exception_test(){
        Comment comment1 = new Comment();
        Comment comment2= new Comment();
        Comment comment3 = new Comment();
        Comment comment4 = new Comment();

        commentRepo.write(comment1);
        commentRepo.write(comment2);
        commentRepo.write(comment3);

        commentRepo.deleteCommentById(1);
        assertEquals(2,commentRepo.count());
        commentRepo.deleteCommentById(2);
        assertEquals(1, commentRepo.count());

    }

}