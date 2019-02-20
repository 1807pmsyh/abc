import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.zs.pms.service.UserService2;
import com.zs.pms.vo.QueryUser;

/*
 * 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService2 {

	@Autowired  //注入业务
	UserService2 us;
	
	@Test
	public void testQuery() { 
	QueryUser query=new QueryUser();
	query.setSex("男");    //性别为男 有几条数据
	System.out.println(us.queryByCon(query).size());	
	}
	
	
	
	
	
	
	
	
}
