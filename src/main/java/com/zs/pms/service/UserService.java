package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

public interface UserService {
	//���Է���
 public void hello();
 
 //�����û�ID���Ȩ���б�
 public List<TPermission>queryByUid(int id);
 
 //����ԭ��Ȩ������˵�
 public List<TPermission>genMenu(List<TPermission>pers);
 
 //��������ѯ
 public List<TUser>queryByCon(QueryUser query);
 
//������������
	public int insertUser(TUser user);
	
	//����ɾ��
	public void deleteByIds(int[] ids);
	
	//�޸�
	public void updateUser(TUser user);
	
	//��ҳ��ѯ
	public List<TUser>queryByPage(int page,QueryUser query);
			
	//���������
	public int queryPageCount(QueryUser query);
	
}
