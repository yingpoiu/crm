package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISysUserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sysuser")
public class SysUserController {
	@Autowired
	private ISysUserService sysUserService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String sysUserLogin(@Param("username") String username, @Param("password") String password,
			HttpSession session) {
		try {
			SysUser sysUser = sysUserService.login(username, password);
			SysRole role = sysUserService.findRoleBySysRoleId(sysUser.getUsrRoleId());

			if (sysUser.getUsrFlag() == 1 && role.getRoleFlag() == 1) { // 判断系统用户及
																		// 角色状态
				session.setAttribute("user", sysUser);
				return "main";
			} else {
				session.setAttribute("msg", "登录失败，当前用户无效!");
				return "index";
			}
		} catch (CrmCommonException e) { // 对异常进行处理
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
			return "index";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String sysUserLogout(HttpSession session) {
		session.removeAttribute("user");
		return "index";
	}

	@RequestMapping("/{curpage}/selectAllUser")
	public String selectAllUser(@PathVariable int curpage, HttpSession session) {
		try {
			PageInfo<SysUser> pageInfo = sysUserService.findAllSysUser(curpage, 5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "systemset/user_manage";
	}
}
