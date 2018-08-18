package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.crm.common.bean.CstActivity;
import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.CstLinkman;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICustomerService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/cust")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/{curpage}/findAllCustomer", method = RequestMethod.GET)
	public String findAllCustomer(@PathVariable int curpage, HttpSession session) {
		try {
			PageInfo<CstCustomer> pageInfo = customerService.findAllCstCustomer(curpage, 5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "customer/list";
	}

	@RequestMapping(value = "/{curpage}/findCstPageByCon", method = RequestMethod.POST)
	public String findCstPageByCon(@PathVariable int curpage, HttpSession session, CstCustomer customer) {
		try {
			PageInfo<CstCustomer> pageInfo = customerService.findCustomerPageByCon(curpage, 5, customer);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "customer/list";
	}

	@RequestMapping(value = "addCustomer", method = RequestMethod.POST)
	public String addCustomer(CstCustomer customer) {
		try {
			customerService.saveCustomer(customer);
			return "redirect:/cust/1/findAllCustomer.action";
		} catch (CrmCommonException e) {
			e.printStackTrace();
			return "redirect:/showAddcustomer.action";
		}
	}

	@RequestMapping("/{custNo}/findLinkman")
	public String findLinkman(@PathVariable long custNo, HttpSession session) {
		try {
			List<CstLinkman> list = customerService.findAllLinkManByCstId(custNo);
			CstCustomer customer = customerService.findCustomerByCstNo(custNo + "");
			session.setAttribute("customer", customer);
			session.setAttribute("linkmans", list);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "customer/linkman";
	}

	// 新建联系人 保存到数据库
	@RequestMapping("/{custNo}/saveNewLinkman")
	public String saveNewLinkman(CstLinkman lkm, @PathVariable String custNo) {
		try {
			CstCustomer cstNo = customerService.findCustomerByCstNo(custNo);
			lkm.setLkmCustId(cstNo.getCustId());
			lkm.setLkmCustName(cstNo.getCustName());
			lkm.setLkmCustNo(cstNo.getCustNo());
			customerService.saveLinkMan(lkm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/cust/" + custNo + "/findLinkman.action";
	}

	@RequestMapping("/{custNo}/findAllActivity")
	public String findActivity(@PathVariable String custNo, HttpSession session) {
		try {
			List<CstActivity> acvs = customerService.findAllCstActivityByCstNo(custNo);
			CstCustomer customer = customerService.findCustomerByCstNo(custNo);
			session.setAttribute("acvs", acvs);
			session.setAttribute("customer", customer);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "customer/activities";
	}
	
	@RequestMapping(value="/{cstNo}/saveNewActivity",method=RequestMethod.POST)
	public String saveActivity(CstActivity activity,HttpSession session) {
		try {
			CstCustomer customer = (CstCustomer) session.getAttribute("customer");
			activity.setAtvCustName(customer.getCustName());
			activity.setAtvCustNo(customer.getCustNo());
			customerService.saveCstActivity(activity);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "forward:/cust/"+activity.getAtvCustNo()+"/findAllActivity.action";
	}
}
