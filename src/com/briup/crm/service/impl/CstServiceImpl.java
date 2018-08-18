package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.CstService;
import com.briup.crm.common.bean.CstServiceExample;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.bean.SysUserExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.CstServiceMapper;
import com.briup.crm.dao.SysUserMapper;
import com.briup.crm.service.interfaces.ICstService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CstServiceImpl implements ICstService {

	@Autowired
	private CstServiceMapper serviceMapper;

	@Autowired
	private SysUserMapper userMapper;

	@Override
	public void save(CstService cstService) throws CrmCommonException {
		if (cstService == null) {
			throw CrmCommonException.getException(403);
		}
		serviceMapper.insert(cstService);
	}

	@Override
	public List<SysUser> findAllManagerName() throws CrmCommonException {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsrRoleIdEqualTo(4L);
		return userMapper.selectByExample(example);
	}

	@Override
	public PageInfo<CstService> findServiceOnDealed(CstService con, int curPage, int row) throws CrmCommonException {
		return null;
	}


	@Override
	public PageInfo<CstService> findAllService(int curPage, int row) throws CrmCommonException {
		PageHelper.startPage(curPage, row);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrStatusEqualTo("新创建");
		List<CstService> list = serviceMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public PageInfo<CstService> findByfp(int curPage, int row) throws CrmCommonException {
		PageHelper.startPage(curPage, row);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrStatusEqualTo("已分配");
		List<CstService> list = serviceMapper.selectByExample(example);
		return new PageInfo<>(list);
	}


	@Override
	public PageInfo<CstService> findBycl(int curPage, int row) throws CrmCommonException {
		PageHelper.startPage(curPage, row);
		CstServiceExample example = new  CstServiceExample();
		example.createCriteria().andSvrStatusEqualTo("已处理");
		List<CstService> list = serviceMapper.selectByExample(example);
		return new PageInfo<>(list);
	}


	@Override
	public void delete(long svrId) throws CrmCommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCstService(CstService cstService) throws CrmCommonException {
		if (cstService == null || cstService.getSvrId() == null) {
			throw CrmCommonException.getException(403);
		}
		CstService service = queryOneByid(cstService.getSvrId());
		if (service.getSvrDueTo() != null) {
			throw  CrmCommonException.getException(405);
		}
		service.setSvrDueTo(cstService.getSvrDueTo());
		service.setSvrStatus(cstService.getSvrStatus());
		serviceMapper.updateByPrimaryKey(service);
	}

	@Override
	public CstService queryOneByid(long svrId) throws CrmCommonException {
		return serviceMapper.selectByPrimaryKey(svrId);
	}

	@Override
	public void updateinfo(CstService cstService) throws CrmCommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void Dealresult(CstService cstService) throws CrmCommonException {

	}

	@Override
	public PageInfo<CstService> findCstServiceByCondition(CstService con, int curPage, int row)
			throws CrmCommonException {
		PageHelper.startPage(curPage, row);
		if (con == null) {
			throw CrmCommonException.getException(403);
		}
		CstServiceExample example = new CstServiceExample();
		example.createCriteria()
				.andSvrCustNameLike("%"+ con.getSvrCustName() +"%")
				.andSvrTypeLike("%"+con.getSvrType()+"%")
				.andSvrTitleLike("%"+ con.getSvrTitle()+"%")
				.andSvrStatusLike("%"+con.getSvrStatus()+"%");
		List<CstService> list = serviceMapper.selectByExample(example);
		return new PageInfo<>(list); 
	}

}
