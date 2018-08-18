package com.briup.crm.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.crm.common.bean.CstLog;
import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ILogService;
import com.briup.crm.service.interfaces.ISysUserService;

@Controller
@RequestMapping("/role")
public class SysRoleController {
	
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private ILogService logService;
	
	@RequestMapping(value="/roleall",method=RequestMethod.GET)
	public String getAllRole(HttpSession session) {
		try {
			List<SysRole> list = sysUserService.findAllRole();
			session.setAttribute("roles", list);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "systemset/role_manage";
	}
	
	
	 //添加角色
    @RequestMapping(value="/addRole",method=RequestMethod.GET)
	public String add(SysRole role,HttpSession session){
    	
		try {
			sysUserService.addRole(role);
			SysUser user = (SysUser) session.getAttribute("user");
			//添加日志
			CstLog log = new CstLog();
			log.setLogDate(new Date());
			log.setLogOp(user.getUsrName());
			log.setLogEvent("新增了角色,角色名称为'"+role.getRoleName()+"'");
			logService.saveLog(log);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "redirect:/role/roleall";
    }
    
    @RequestMapping(value="/{roleId}/deleteRole",method=RequestMethod.GET)
    public String deleteRole(@PathVariable long roleId,HttpSession session){
		try {
			sysUserService.deleteRole(roleId);
			SysUser user = (SysUser) session.getAttribute("user");
			CstLog log = new CstLog();
			log.setLogDate(new Date());
			log.setLogOp(user.getUsrName());
			log.setLogEvent("删除了角色'"+user.getUsrName()+"'");
			logService.saveLog(log);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "redirect:/role/roleall";
	}
    
    @RequestMapping(value="/{roleId}/editRole",method=RequestMethod.GET)
    public String editRole(@PathVariable long roleId,HttpSession session){
    	try {
			session.setAttribute("role", sysUserService.findRoleBySysRoleId(roleId));
			return "systemset/role_update";
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
			return "redirect:/role/roleall";
		}
	}
    @RequestMapping(value="/roleupdate",method=RequestMethod.POST)
    public String roleupdate(SysRole role,HttpSession session){
    	try {
			sysUserService.updateRole(role);
			SysUser user = (SysUser) session.getAttribute("user");
			CstLog log = new CstLog();
			log.setLogDate(new Date());
			log.setLogOp(user.getUsrName());
			log.setLogEvent("修改了编号为：'"+role.getRoleId()+"' 的信息");
			logService.saveLog(log);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
    	return "redirect:/role/roleall";
	}
    
    
}
