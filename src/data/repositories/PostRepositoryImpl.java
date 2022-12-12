package data.repositories;

import data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository{
    private  int idGenerate;
    private List<Post> postDb = new ArrayList<>();
    @Override
    public Post save(Post post) {
        if (post.getId()!=0) update(post);  //update if the id is not new
        else {
        postDb.add(post);
        idGenerate++;
        post.setId(idGenerate);
    }
        return post;
    }

        private void update(Post post) {
            //find the original
            Post savedPost = findById(post.getId());
            //set with new details
            savedPost.setTitle(post.getTitle());
            savedPost.setBody(post.getBody());
        }
    @Override
    public Post findById(int id) {
        for (Post post : postDb) if (post.getId()==id) return post;

        return null;
    }

    @Override
    public List<Post> findAll() {
        return postDb;
    }

    @Override
    public long count() {
        return postDb.size();
    }

    @Override
    public void delete(Post post) {

    }

    @Override
    public void delete(int id) {
        for (Post p: postDb) if (p.getId()==id)  {
            postDb.remove(p);
                break;

        }

    }
}



