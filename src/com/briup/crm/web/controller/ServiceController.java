package com.briup.crm.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.CstService;
import com.briup.crm.common.bean.SysUser;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.ICstService;
import com.briup.crm.service.interfaces.ICustomerService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	private ICustomerService customerService;
	@Autowired
	private ICstService cstService;

	@RequestMapping(value = "/findAllCustomerBaseOnService", method = RequestMethod.GET)
	public String findAllCustomerBaseOnService(HttpSession session) {
		try {
			List<CstCustomer> customers = customerService.findAllCustomer();
			session.setAttribute("customers", customers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "service/add";
	}

	@RequestMapping(value = "/addService", method = RequestMethod.POST)
	public String addService(CstService service, HttpServletRequest request) {
		try {
			cstService.save(service);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			request.setAttribute("msg", "添加失败,原因:" + e.getMessage());
		}
		return "service/add";
	}
	
	@RequestMapping("/{curpage}/findAllService")
	public String findAllService(@PathVariable int curpage, HttpSession session) {
		try {
			
			PageInfo<CstService> pageInfo = cstService.findAllService(curpage, 5);
			List<SysUser> sysUsers = cstService.findAllManagerName();
			session.setAttribute("pageInfo", pageInfo);
			session.setAttribute("mns", sysUsers);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "service/dispatch";
	}
	
	@RequestMapping("/{curPage}/findServiceByCondition")
	public String findServiceByCondition(CstService service,@PathVariable int curPage,HttpSession session) {
		try {
			PageInfo<CstService> pageInfo = cstService.findCstServiceByCondition(service, curPage, 5);
			List<SysUser> sysUsers = cstService.findAllManagerName();
			session.setAttribute("pageInfo", pageInfo);
			session.setAttribute("mns", sysUsers);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "service/dispatch";
	}
	
	// 更新已分配的服务
	@RequestMapping("/updateService")
	public String updateService(CstService service,HttpSession session) {
		try {
			cstService.updateCstService(service);
			return "redirect:/service/1/findAllService";
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
			return "service/dispatch";
		}
	}

	@RequestMapping("/{curPage}/findAllFp")
	public String findAllFp(@PathVariable int curPage,HttpSession session) {
		try {
			PageInfo<CstService> pageInfo = cstService.findByfp(curPage, 6);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "service/deal";
	}
	
	
	
	@RequestMapping("/{curPage}/findByConFp")
	public String findByConFp(CstService service,@PathVariable int curPage,HttpSession session) {
		try {
			PageInfo<CstService> pageInfo = cstService.findCstServiceByCondition(service, curPage, 5);
			List<SysUser> sysUsers = cstService.findAllManagerName();
			session.setAttribute("pageInfo", pageInfo);
			session.setAttribute("mns", sysUsers);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "service/deal";
	}
	
	
	//findFeedback
	@RequestMapping("/{curpage}/findFeedback")
	public String findFeedBack(@PathVariable int curpage, HttpSession session) {
		try {
			PageInfo<CstService> pageInfo = cstService.findBycl(curpage, 5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "service/feedback";
	}

	//findServiceOnDealed
	@RequestMapping("/{curpage}/findServiceBaseOnDealed")
	public String findServiceOnDealed(@PathVariable int curpage, CstService service,HttpSession session) {
		try {
			PageInfo<CstService> pageInfo = cstService.findCstServiceByCondition(service, curpage, 5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "service/feedback";
	}
	//queryOne
	@RequestMapping("/{id}/queryOne")
	public String queryOne(@PathVariable long id,HttpSession session) {
		try {
			CstService cst = cstService.queryOneByid(id);
			session.setAttribute("cst", cst);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "service/feedback_detail";
	}
}
