package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.SalChance;
import com.briup.crm.common.bean.SalPlan;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ISalChanceService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/plan")
public class DevelopPlanController {

	@Autowired
	private ISalChanceService salChanceService;

	@RequestMapping("/{curpage}/developPlan")
	public String developPlan(@PathVariable int curpage, HttpSession session) {
		try {
			PageInfo<SalChance> pageInfo = salChanceService.findSalChanceByPage(curpage, 5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "marketing/dev";
	}

	@RequestMapping("/{chanceId}/doplan")
	public String doplan(@PathVariable long chanceId, HttpSession session) {
		try {
			SalChance chance = salChanceService.findOneSalChance(chanceId);
			session.setAttribute("chance", chance);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "marketing/dev_plan";
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
		return "marketing/dev";
	}
	
	@RequestMapping("/{chcId}/todoplan")
	public String todoplan(@PathVariable int chcId, HttpSession session) {
		try {
			SalChance chance = salChanceService.findOneSalChance(chcId);
			SalPlan salPlan = salChanceService.findSalPlan(chcId);
			session.setAttribute("plan", salPlan);
			session.setAttribute("chance", chance);
			return "marketing/dev_execute";
		} catch (CrmCommonException e) {
			e.printStackTrace();
			return "marketing/dev";
		}
	}
	
	
	@RequestMapping("/{chcId}/deleteplan")
	public String deleteplan(@PathVariable int chcId, HttpSession session) {
		try {
			SalPlan plan = salChanceService.findSalPlan(chcId);
			if (plan == null) {
				session.setAttribute("msg", "未制定计划，无需终止");
				return "marketing/dev_execute";
			}
			salChanceService.deleteSalPlan(plan.getPlaId());
			salChanceService.deleteSalChance(chcId);
			session.setAttribute("msg", "计划已终止");
			return "marketing/dev";
		} catch (CrmCommonException e) {
			e.printStackTrace();
			if (e.getErrcode() == 404) {
				session.setAttribute("msg", "未制定计划，无需终止");
			}
			return "marketing/dev_execute";
		}
	}
	
	//saveplan
	@RequestMapping("/saveplan")
	public String saveplan(SalPlan plan,HttpSession session) {
		try {
			salChanceService.savePlan(plan);
			session.setAttribute("msg", "计划保存成功!");
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "计划保存失败!");
		}
		return "redirect:/plan/"+plan.getPlaChcId()+"/todoplan.action";
	}
	
	//updateplan
	@RequestMapping("/{chanceId}/updateplan")
	public String saveplan(@PathVariable long chanceId,HttpSession session) {
		try {
			SalPlan plan = salChanceService.findSalPlan(chanceId);
			plan.setPlaResult("success");
			salChanceService.updateSalPlan(plan);
			SalChance chance = salChanceService.findOneSalChance(chanceId);
			chance.setChcStatus("success");
			salChanceService.updateChance(chance);
			session.setAttribute("msg", "开发成功");
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "系统出错");
		}
		return "marketing/dev_execute";
	}
	
}
