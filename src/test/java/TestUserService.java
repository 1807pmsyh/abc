import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;
/*
 * ����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService {
@Autowired  //ע��ҵ��
	UserService us;
	

    //@Test
	public void testHello() {
		us.hello();
	}
	
	
	//@Test
	public void testlogin() {
		/*for(TPermission per:us.queryByUid(3084)) {
			System.out.println(per.getPname());
		}*/
		List<TPermission>list1=us.queryByUid(3084);
		for(TPermission per:list1) {
			System.out.println(per.getPname());
		}
		System.out.println("-------------�����------------------");
		for (TPermission per1:us.genMenu(list1)) {
			//һ��Ȩ��
			System.out.println(per1.getPname());
			for (TPermission per2:per1.getChildren()) {
				System.out.println("-----"+per2.getPname());
			}
		} 
	}
	
	
	//@Test
	public void testQuery() {     //��������ѯ
		//������ѯ����
		QueryUser query=new QueryUser();
		query.setLoginname("qwe");
		query.setPassword("123");
		query.setSex("Ů");
		System.out.println(us.queryByCon(query).size());
	}
	
	//@Test
	public void deleteQuery() {   //����ɾ��
		int[] ids= {1024};
		us.deleteByIds(ids);
	}
	
	//@Test
	public void UpdateQuery() {    //�޸�һ������
		TUser user=new TUser();
		TDep dep=new TDep();
		
		user.setBirthday(new Date(0));
		user.setDept(0);
		dep.setId(0);
		user.setId(1021);
		user.setEmail("1234up@qq.com");
		user.setIsenabled(1);
		user.setLoginname("test1");
		user.setPassword("1235");
		user.setRealname("zzzaa");
		user.setSex("��");
		user.setCreator(1);
		user.setPic("insert");
		us.updateUser(user);
		
	}
	
	
	
	@Test
	public void testInsert() {    //����һ����������
		TUser user = new TUser();
		//user.setId(1020);
		TDep dep = new TDep();
		dep.setId(6);
		user.setDept(0);
		user.setBirthday(new Date(0));
		user.setEmail("1234@qq.com");
		user.setIsenabled(1);
		user.setLoginname("test11111");
		user.setPassword("1234");
		user.setRealname("zzzzzzz");
		user.setSex("Ů");
		user.setCreator(1000);
		user.setPic("insert.jsp");
		
		System.out.println(us.insertUser(user));
	}
	
	//@Test
	public void tQ() {   //����ҳ��
	//������ѯ����
	QueryUser query=new QueryUser();
	query.setSex("��");
	for (TUser user:us.queryByPage(2, query)) {
		System.out.println(user.getId()+"..."+user.getLoginname());
	}
	System.out.println("��"+us.queryPageCount(query)+"ҳ");
		
	}
	
	
	
	//@Test
	public void testlog() { //��־��ѯ
		TUser user=new TUser();
		us.insertUser(user);
	}
	
	
	
	
	
	
	
	
}













