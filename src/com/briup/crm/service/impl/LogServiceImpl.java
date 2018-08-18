package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.CstLog;
import com.briup.crm.common.bean.CstLogExample;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.CstLogMapper;
import com.briup.crm.service.interfaces.ILogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class LogServiceImpl implements ILogService {
	
	@Autowired
	private CstLogMapper logMapper;
	
	@Override
	public void saveLog(CstLog log) throws CrmCommonException {
		if (log == null) {
			throw CrmCommonException.getException(403);
		}
		logMapper.insert(log);
	}

	@Override
	public PageInfo<CstLog> findAllLog(int curpage, int row) throws CrmCommonException {
		PageHelper.startPage(curpage, row);
		return new PageInfo<>(findAllLog());
	}

	@Override
	public List<CstLog> findAllLog() throws CrmCommonException {
		CstLogExample example = new CstLogExample();
		return logMapper.selectByExample(example);
	}

}
