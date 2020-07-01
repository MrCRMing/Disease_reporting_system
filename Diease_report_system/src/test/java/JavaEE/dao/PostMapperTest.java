package JavaEE.dao;

import JavaEE.BaseTest;
import JavaEE.domain.Post;
import JavaEE.domain.User;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PostMapperTest extends BaseTest {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void testAdd(){
        User user = new User();
        user.setUser_id(1);

        Post post = new Post();
        post.setContent("CONTENT");
        post.setPublisher(user);
        post.setPublish_date(new Date());
        post.setPublisher_name("Test");
        postMapper.insertPost(post);
        System.out.println(post);
    }

    @Test
    public void addMore(){
        for(int i=0; i < 20; i++){
            testAdd();
        }
    }
    @Test
    public void testGet(){
        Post post = postMapper.queryPostById(1);
        System.out.println(post);
    }

    @Test
    public void testGets(){
        User user = new User();
        user.setUser_id(1);

        Post post = new Post();

        post.setPublisher(user);
        post.setContent("D");

        List<Post> posts = postMapper.queryPostByCondition(post,new RowBounds(1,5));
        for(Post p:posts){
            System.out.println(p);
        }
    }

    @Test
    public void testGetsMore(){
        List<Post> posts = postMapper.queryPostsByUserId(1,null);
        for (Post p: posts){
            System.out.println(p.getPublisher());
        }
        posts.get(0).getPublisher().setUsername("666");
        for (Post p: posts){
            System.out.println(p.getPublisher());
        }
    }

}
