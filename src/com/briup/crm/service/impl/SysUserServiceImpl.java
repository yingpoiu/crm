package com.briup.crm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.SysRole;
import com.briup.crm.common.bean.SysRoleExample;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.bean.SysUserExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.SysRoleMapper;
import com.briup.crm.dao.SysUserMapper;
import com.briup.crm.service.interfaces.ISysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SysUserServiceImpl implements ISysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Override
	public SysUser login(String username, String password) throws CrmCommonException {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			throw CrmCommonException.getException(401);
		}
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsrNameEqualTo(username).andUsrPasswordEqualTo(password);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if (list == null || list.size() <= 0) {
			throw CrmCommonException.getException(402);
		}
		return list.get(0);
	}


	@Override
	public List<SysUser> findAllMgr() throws CrmCommonException {
		return null;
	}


	@Override
	public List<SysRole> findAllRole() throws CrmCommonException {
		SysRoleExample example = new SysRoleExample();
		List<SysRole> list = sysRoleMapper.selectByExample(example);
		if (list == null || list.size() <= 0) {
			throw CrmCommonException.getException(404);
		}
		return list;
	}


	@Override
	public SysRole findRoleBySysRoleId(long roleId) throws CrmCommonException {
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}


	@Override
	public void updateRole(SysRole role) throws CrmCommonException {
		if (role == null || role.getRoleId() == null) {
			throw CrmCommonException.getException(403);
		}
		SysRole sysRole = findRoleBySysRoleId(role.getRoleId());
		sysRole.setRoleFlag(role.getRoleFlag());
		sysRole.setRoleName(role.getRoleName());
		sysRole.setRoleDesc(role.getRoleDesc());
		sysRoleMapper.updateByPrimaryKey(sysRole);
	}


	@Override
	public PageInfo<SysUser> findAllSysUser(int curpage, int row) throws CrmCommonException {
		PageHelper.startPage(curpage, row);
		SysUserExample example = new SysUserExample();
		List<SysUser> list = sysUserMapper.selectByExample(example);
		return new PageInfo<>(list);
	}


	@Override
	public int getAllRows() throws CrmCommonException {
		return 0;
	}


	@Override
	public SysUser findOneUser(long usrId) throws CrmCommonException {
		return sysUserMapper.selectByPrimaryKey(usrId);
	}


	@Override
	public void updateUser(SysUser user) throws CrmCommonException {
		if (user == null || user.getUsrId() == null) {
			throw CrmCommonException.getException(403);
		}
		sysUserMapper.updateByPrimaryKey(user);
	}


	@Override
	public void addUser(SysUser user) throws CrmCommonException {
		if (user == null) {
			throw CrmCommonException.getException(403);
		}
		sysUserMapper.insert(user);
	}


	@Override
	public void deleteUser(long usrId) throws CrmCommonException {
		sysUserMapper.deleteByPrimaryKey(usrId);
	}


	@Override
	public void addRole(SysRole role) throws CrmCommonException {
		if (role == null) {
			throw CrmCommonException.getException(403);
		}
		sysRoleMapper.insert(role);
	}


	@Override
	public void deleteRole(long roleId) throws CrmCommonException {
		sysRoleMapper.deleteByPrimaryKey(roleId);
	}

	
}
