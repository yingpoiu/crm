package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.CstLog;
import com.briup.crm.service.interfaces.ILogService;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private ILogService logService;
	
	@RequestMapping("/{curpage}/selectAllLog")
	public String all(@PathVariable int curpage,HttpSession session) {
		try {
			PageInfo<CstLog> pageInfo = logService.findAllLog(curpage, 20);
			session.setAttribute("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "systemset/log_review";
	}
	
	
}