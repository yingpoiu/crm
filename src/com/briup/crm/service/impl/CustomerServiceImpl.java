package com.briup.crm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.CstActivity;
import com.briup.crm.common.bean.CstActivityExample;
import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.CstCustomerExample;
import com.briup.crm.common.bean.CstLinkman;
import com.briup.crm.common.bean.CstLinkmanExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.CstActivityMapper;
import com.briup.crm.dao.CstCustomerMapper;
import com.briup.crm.dao.CstLinkmanMapper;
import com.briup.crm.service.interfaces.ICustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CstCustomerMapper customerMapper;
	
	@Autowired
	private CstLinkmanMapper manMapper;
	
	@Autowired
	private CstActivityMapper activityMapper;

	@Override
	public List<CstCustomer> findAllCustomer() throws CrmCommonException {
		CstCustomerExample example = new CstCustomerExample();
		return customerMapper.selectByExample(example);
	}

	@Override
	public CstCustomer findCustomerById(long id) throws CrmCommonException {
		return customerMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateCustomer(CstCustomer cstCustomer) throws CrmCommonException {
		if (cstCustomer == null || cstCustomer.getCustId() == null) {
			throw CrmCommonException.getException(403);
		}
		customerMapper.insert(cstCustomer);
	}

	@Override
	public PageInfo<CstCustomer> findAllCstCustomer(int curpage, int row) throws CrmCommonException {
		PageHelper.startPage(curpage, row);
		return new PageInfo<>(findAllCustomer());
	}

	@Override
	public void saveLinkMan(CstLinkman cstLinkman) throws CrmCommonException {
		if (cstLinkman == null) {
			throw CrmCommonException.getException(403);
		}
		manMapper.insert(cstLinkman);
	}

	@Override
	public void deleteLinkMan(long id) throws CrmCommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CstLinkman> findAllLinkManByCstId(long cstId) throws CrmCommonException {
		CstLinkmanExample example = new CstLinkmanExample();
		example.createCriteria().andLkmCustIdEqualTo(cstId);
		return manMapper.selectByExample(example);
	}

	@Override
	public CstLinkman findLinkManById(long id) throws CrmCommonException {
		return null;
	}

	@Override
	public void updateLinkman(CstLinkman lkm) throws CrmCommonException {
		
	}

	@Override
	public void deleteCustomerById(long id) throws CrmCommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveCstActivity(CstActivity cstActivity) throws CrmCommonException {
		if(cstActivity == null) {
			throw CrmCommonException.getException(403);
		}
		activityMapper.insert(cstActivity);
		
	}

	@Override
	public List<CstActivity>  findAllCstActivityByCstNo(String cstNo) throws CrmCommonException {
		if (StringUtils.isBlank(cstNo)) {
			throw CrmCommonException.getException(403);
		}
		CstActivityExample example = new CstActivityExample();
		example.createCriteria().andAtvCustNoEqualTo(cstNo);
		return activityMapper.selectByExample(example);
	}

	@Override
	public CstActivity findCstActivityById(long atvId) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAtv(CstActivity cstActivity) throws CrmCommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAtvById(long atvId) throws CrmCommonException {
		// TODO Auto-generated method stub

	}


	@Override
	public void saveCustomer(CstCustomer cst) throws CrmCommonException {
		if (cst == null) {
			throw CrmCommonException.getException(403);
		}
		customerMapper.insert(cst);
	}

	@Override
	public PageInfo<CstCustomer> findCustomerPageByCon(int curpage, int row, CstCustomer cstCustomer)
			throws CrmCommonException {
		if (cstCustomer == null) {
			throw CrmCommonException.getException(403);
		}
		PageHelper.startPage(curpage, row);
		/*
		 * 拼接 查询条件
		 */
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria()
				.andCustNoLike("%" + cstCustomer.getCustNo() + "%")
				.andCustNameLike("%" + cstCustomer.getCustName() + "%")
				.andCustRegionLike("%" + cstCustomer.getCustRegion() + "%")
				.andCustManagerNameLike("%" + cstCustomer.getCustManagerName() + "%")
				.andCustLevelLabelLike("%" + cstCustomer.getCustLevelLabel() + "%");
		List<CstCustomer> list = customerMapper.selectByExample(example); // 得到查询结果
		System.out.println(list.size());
		return new PageInfo<>(list);
	}

	@Override
	public CstCustomer findCustomerByCstNo(String cstNo) throws CrmCommonException {
		if (StringUtils.isBlank(cstNo)) {
			throw CrmCommonException.getException(403);
		}
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustNoEqualTo(cstNo);
		List<CstCustomer> list = customerMapper.selectByExample(example); // 得到查询结果
		if (list == null || list.size() <= 0) {
			throw CrmCommonException.getException(404);
		}
		return list.get(0);
	}

	@Override
	public CstCustomer findCustomerByCstName(String cstName) throws CrmCommonException {
		if (StringUtils.isBlank(cstName)) {
			throw CrmCommonException.getException(403);
		}
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustNameEqualTo(cstName);
		List<CstCustomer> list = customerMapper.selectByExample(example); // 得到查询结果
		if (list == null || list.size() <= 0) {
			throw CrmCommonException.getException(404);
		}
		return list.get(0);
	}

	@Override
	public Set<String> findAllCustomerLevelLable() throws CrmCommonException {
		List<CstCustomer> customers = findAllCustomer();
		Set<String> set = new HashSet<>();
		for (CstCustomer cstCustomer : customers) {
			set.add(cstCustomer.getCustLevelLabel());
		}
		return set;
	}

	@Override
	public List<CstCustomer> findCstCustomerByLevelLable(String levelLable) throws CrmCommonException {
		if (StringUtils.isBlank(levelLable)) {
			throw CrmCommonException.getException(403);
		}
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustLevelLabelEqualTo(levelLable);
		return customerMapper.selectByExample(example);
	}

	@Override
	public Set<Integer> findAllCustomerCredit() throws CrmCommonException {
		List<CstCustomer> customers = findAllCustomer();
		Set<Integer> set = new HashSet<>();
		for (CstCustomer cstCustomer : customers) {
			set.add(cstCustomer.getCustCredit());
		}
		return set;
	}

	@Override
	public List<CstCustomer> findCstCustomerByCredit(int credit) throws CrmCommonException {
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustCreditEqualTo(credit);
		return customerMapper.selectByExample(example);
	}

	@Override
	public Set<Integer> findAllCustomerSatisfy() throws CrmCommonException {
		List<CstCustomer> customers = findAllCustomer();
		Set<Integer> set = new HashSet<>();
		for (CstCustomer cstCustomer : customers) {
			set.add(cstCustomer.getCustSatisfy());
		}
		return set;
	}

	@Override
	public List<CstCustomer> findCstCustomerBySatisfy(int satisfy) throws CrmCommonException {
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustSatisfyEqualTo(satisfy);
		return customerMapper.selectByExample(example);
	}

}
