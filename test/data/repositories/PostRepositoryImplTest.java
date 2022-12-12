package data.repositories;

import data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostRepositoryImplTest {
    PostRepository postRepository;
    @BeforeEach
    void setUp() {postRepository = new PostRepositoryImpl();
    }
    @Test
    public void saveNewPost_countShouldBeOne_Test(){
        Post post = new Post();
        post.setBody("Our post body");
        post.setTitle("Our post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
    }
    @Test
    public  void saveNewPost_findById_shouldReturnSavedPostTest(){
        Post post = new Post();
        post.setBody("Our post body");
        post.setTitle("Our post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post savedPost = postRepository.findById(1);
        assertEquals(post, savedPost);
        Post post2 = new Post();
        postRepository.save(post2);
        assertEquals(post2, postRepository.findById(2));
    }
    @Test
    public void saveNewPost_updatePost_countIsOneTest(){
        Post post = new Post();
        post.setTitle("Our post title");
        post.setBody("Our post body");
        postRepository.save(post);

        Post updatedPost = new Post();
        updatedPost.setId(1);
        updatedPost.setBody("updated body");
        updatedPost.setTitle("updated title");
        postRepository.save(updatedPost);
        assertEquals(1L, postRepository.count());
        assertEquals(post, postRepository.findById(1));
        assertEquals("updated body", post.getBody());
        assertEquals("updated title", post.getTitle());
    }
    @Test
    public void deleteItem_countIsZeroTest(){
        Post post = new Post();
        post.setBody("Our post body");
        post.setTitle("Our post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post post2 = new Post();
        post2.setTitle("new title2");
        post2.setBody("new body2");
        postRepository.save(post2);
        assertEquals(2, postRepository.count() );


        Post post3 = new Post();
        post2.setTitle("new title3");
        post2.setBody("new body3");
        postRepository.save(post3);

        Post post4 = new Post();
        post2.setTitle("new title4");
        post2.setBody("new body4");
        postRepository.save(post4);

        postRepository.delete(4);
        assertEquals(3, postRepository.count());

    }
    @Test
    public void delete_Exception_test(){
        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        post3.setTitle("New post3");
        post3.setBody("new body3");
        Post post4 = new Post();

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        postRepository.delete(1);
        assertEquals(2,postRepository.count());
        postRepository.delete(2);
        assertEquals(1,postRepository.count());
        System.out.println(post3.getBody());

        postRepository.save(post4);

        assertEquals(4,post4.getId());
    }
}