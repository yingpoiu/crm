package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.Storage;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.IBasicDataService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/storage")
public class StorageController {

	@Autowired
	private IBasicDataService basicDataSerivice;

	@RequestMapping("/{curpage}/findStorage")
	public String findStorage(@PathVariable int curpage, HttpSession session) {
		try {
			PageInfo<Storage> pageInfo = basicDataSerivice.findStorageAll(curpage, 5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "basicdata/storage";

	}
	
	@RequestMapping("/{curpage}/findStorageByCon")
	public String findStorageByCon(@PathVariable int curpage,Storage storage, HttpSession session) {
		try {
			PageInfo<Storage> pageInfo = basicDataSerivice.findStorage(storage, curpage, 5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "basicdata/storage";

	}
}
