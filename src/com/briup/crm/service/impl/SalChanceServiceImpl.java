package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.SalChance;
import com.briup.crm.common.bean.SalChanceExample;
import com.briup.crm.common.bean.SalPlan;
import com.briup.crm.common.bean.SalPlanExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.SalChanceMapper;
import com.briup.crm.dao.SalPlanMapper;
import com.briup.crm.service.interfaces.ISalChanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SalChanceServiceImpl implements ISalChanceService {
	
	@Autowired
	private SalChanceMapper salChanceMapper;
	@Autowired
	private SalPlanMapper salPlanMappper;

	@Override
	public void saveChance(SalChance sc) throws CrmCommonException {
		if (sc == null) {
			throw CrmCommonException.getException(403);
		}
		sc.setChcStatus("develop");
		salChanceMapper.insert(sc);
	}


	@Override
	public PageInfo<SalChance> findSalChanceByPage(int curpage, int row) throws CrmCommonException {
		PageHelper.startPage(curpage, row);
		SalChanceExample example = new SalChanceExample();
		List<SalChance> list = salChanceMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<SalPlan> findAllSalPlan() throws CrmCommonException {
		return null;
	}

	@Override
	public List<SalPlan> findSalPlans(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<SalPlan> findSalPlanByPage(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void updateChance(SalChance sc) throws CrmCommonException {
		salChanceMapper.updateByPrimaryKey(sc);
	}

	@Override
	public SalChance findOneSalChance(long chcId) throws CrmCommonException {
		return salChanceMapper.selectByPrimaryKey(chcId);
	}

	@Override
	public SalPlan findSalPlan(long chcId) throws CrmCommonException {
		SalPlanExample example = new SalPlanExample();
		example.createCriteria().andPlaChcIdEqualTo(chcId);
		List<SalPlan> list = salPlanMappper.selectByExample(example);
		if (list == null || list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public void deleteSalChance(long chcId) throws CrmCommonException {
		salChanceMapper.deleteByPrimaryKey(chcId);
	}

	@Override
	public void savePlan(SalPlan sp) throws CrmCommonException {
		salPlanMappper.insert(sp);
	}

	@Override
	public void deleteSalPlan(long plaId) throws CrmCommonException {
		salPlanMappper.deleteByPrimaryKey(plaId);
	}

	@Override
	public void updateSalPlan(SalPlan sp) throws CrmCommonException {
		salPlanMappper.updateByPrimaryKey(sp);
	}


	@Override
	public PageInfo<SalChance> findSalPageByCon(int curpage, int row, SalChance sc) throws CrmCommonException {
		if (sc == null) {
			throw CrmCommonException.getException(403);
		}
		PageHelper.startPage(curpage, row);
		SalChanceExample example = new SalChanceExample();
		example.createCriteria()
				.andChcCustNameLike("%" + sc.getChcCustName() + "%")
				.andChcTitleLike("%" + sc.getChcTitle() + "%")
				.andChcLinkmanLike("%" + sc.getChcLinkman() + "%");
		List<SalChance> list = salChanceMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

}
