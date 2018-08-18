package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.SalChance;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICstService;
import com.briup.crm.service.interfaces.ISalChanceService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sal")
public class SaleChanceController {
	@Autowired
	private ISalChanceService salChanceService;
	@Autowired
	private ICstService cstService;
	
	
	@RequestMapping("/{curpage}/chanceall")
	public String chanceall(@PathVariable int curpage,HttpSession session) {
		try {
			PageInfo<SalChance> pageInfo = salChanceService.findSalChanceByPage(curpage, 5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "marketing/list";
	}

	@RequestMapping("/{curpage}/findByCon")
	public String findByCon(@PathVariable int curpage,SalChance chance,HttpSession session) {
		try {
			PageInfo<SalChance> pageInfo = salChanceService.findSalPageByCon(curpage, 10, chance);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "marketing/list";
	}
	
	@RequestMapping("/chancesave")
	public String chancesave(SalChance chance) {
		try {
			salChanceService.saveChance(chance);
			return "redirect:/sal/1/chanceall.action";
		} catch (CrmCommonException e) {
			e.printStackTrace();
			return "marketing/add_salchance";
		}
	}
	
	@RequestMapping("/{chanceId}/chancedispatch")
	public String chancesave(@PathVariable long chanceId,HttpSession session) {
		try {
			SalChance chance = salChanceService.findOneSalChance(chanceId);
			List<SysUser> list = cstService.findAllManagerName();
			session.setAttribute("manager", list);
			session.setAttribute("chance", chance);
			return "marketing/dispatch";
		} catch (CrmCommonException e) {
			e.printStackTrace();
			return "marketing/list";
		}
	}
	

	
}
