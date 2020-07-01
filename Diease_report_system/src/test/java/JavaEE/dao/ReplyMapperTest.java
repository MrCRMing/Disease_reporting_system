package JavaEE.dao;

import JavaEE.BaseTest;
import JavaEE.domain.Reply;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReplyMapperTest extends BaseTest {
    @Autowired
    private ReplyMapper replyMapper;

    @Test
    public void testGet(){
        List<Reply> replies = replyMapper.queryRepliesByUserId(2, new PageRowBounds(1,5));
        for(Reply r: replies){
            System.out.println(r);
        }
    }

    @Test
    public void testGet2(){
        List<Reply> replies = replyMapper.queryRepliesByPostId(28, new PageRowBounds(1,5));
        for(Reply r: replies){
            System.out.println(r);
        }
    }
}
