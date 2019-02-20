package com.zs.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.MD5;
import com.zs.pms.vo.QueryLogin;
import com.zs.pms.vo.QueryUser;



/**
 * ������
 * @author Administrator
 *
 */
@Controller   //��һ��������
public class HelloController {
	
	@Autowired
	UserService us;
	
	
	
    //����ӳ��  ��urlƥ��
	@RequestMapping("/tologin.do")
	//ȥ��¼ҳ��
	public String tologin() {
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(QueryLogin login,HttpSession session,ModelMap model) {
		// 1,��֤��֤��
		String ocode=(String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		// ���ɵ���֤���ҳ�����֤�벻���
		if (!ocode.equals(login.getChkcode())) {
			model.addAttribute("MSG","��֤�벻ƥ�䣬����������");
			return "login";
		}
		
		//2.��֤�˺ź�����
		//װ������
		QueryUser query=new QueryUser();
		query.setLoginname(login.getUsername());  //��¼��
		
		//MD5����
		MD5 md5=new MD5();
		
		query.setPassword(md5.getMD5ofStr(login.getPassword())); //����
		query.setIsenabled(1);  //���ÿ���
		//���ص�½���û�
		List<TUser>users=us.queryByCon(query);
		//��¼ʧ��
		if (users==null||users.size()!=1) {
			model.addAttribute("MSG","�û���������������������������");
			return "login";
		}
		//��½�ɹ� װsession
		session.setAttribute("CUSER", users.get(0));
		   return "main";  //ȥ��ҳ��
	}
	
	
	
	
	
	@RequestMapping("/top.do")
	//ȥ����ҳ��
	public String top() {
		return "top";
	}		
		
	@RequestMapping("/left.do")
	//ȥ���ҳ��
	public String left(HttpSession session,ModelMap model) {
		//
		TUser cu=(TUser)session.getAttribute("CUSER");
		//
		List<TPermission>list1=us.queryByUid(cu.getId());
		//
		model.addAttribute("MENU",us.genMenu(list1));
		return "left";
	}		
		
	@RequestMapping("/right.do")
	//ȥ�Ҳ�ҳ��
	public String right() {
		return "right";
	}			
		
	
}
