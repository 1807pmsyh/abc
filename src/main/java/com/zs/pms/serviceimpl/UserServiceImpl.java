package com.zs.pms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.UserDao;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.Constants;
import com.zs.pms.vo.QueryUser;



@Service  //用Spring生成 用来代替bean普通类
@Transactional //需要开启事务的业务对象
public class UserServiceImpl implements UserService{
    @Autowired  //按类型自动注入 @Autowired
	UserDao dao;  
    
	@Override
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("hello spring");
	}

	@Override
	public List<TPermission> queryByUid(int id) {
		// TODO Auto-generated method stub
		return dao.queryByUid(id);
	}

	@Override
	public List<TPermission> genMenu(List<TPermission> pers) {
		// TODO Auto-generated method stub
		//创建新容器
		List<TPermission>list=new ArrayList<>();
		//遍历权限列表
		for (TPermission per:pers) {
			//一级菜单
			if (per.getLev()==1) {
				//加载该一级菜单下的二级菜单
				//遍历
				for (TPermission per2:pers) {
					//二级权限的上级id等于一级权限的id
					if (per2.getPid()==per.getId()) {
						//添加子权限
						per.addChild(per2);
					}
				}
				//加到新的集合中
				list.add(per);
			}
		}
		return list;
	}

	@Override
	public List<TUser> queryByCon(QueryUser query) {
		// TODO Auto-generated method stubs
		return dao.queryByCon(query);
	}

	@Override
	//该方法只要有异常就回滚事务
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(TUser user) {
		// TODO Auto-generated method stub
		//新增
		dao.insertUser(user);
		int a=1/0;  //产生异常
		dao.insertUser(user);
		return user.getId();  //返回主键
	}

	@Override
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteByIds(ids);
	}

	@Override
	public void updateUser(TUser user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}

	@Override
	public List<TUser> queryByPage(int page, QueryUser query) {
		// TODO Auto-generated method stub
		int start=(page-1) * Constants.PAGECONT+1;
		int end=page * Constants.PAGECONT;
		query.setStart(start);
		query.setEnd(end);
		return dao.queryByPage(query);
	}

	@Override
	public int queryPageCount(QueryUser query) {
		// TODO Auto-generated method stub
		int cont=dao.queryCount(query);
		if (cont%Constants.PAGECONT==0) {
			return cont/Constants.PAGECONT;
		}else {
			return cont/Constants.PAGECONT+1;
		}
		
	}

	
	

	
	
		
	

}
