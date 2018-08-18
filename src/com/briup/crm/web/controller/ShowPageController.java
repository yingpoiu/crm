package com.briup.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowPageController {
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@RequestMapping("/showleft")
	public String showleft() {
		return "left";
	}

	@RequestMapping("/showswitch")
	public String showswitch() {
		return "switch";
	}

	@RequestMapping("/showtop")
	public String showtop() {
		return "top";
	}

	@RequestMapping("/showAddRole")
	public String showAddRole() {
		return "systemset/addRole";
	}

	@RequestMapping("/showRolemanage")
	public String showRolemanage() {
		return "systemset/role_manage";
	}

	@RequestMapping("/showhelp")
	public String showhelp() {
		return "help";
	}

	@RequestMapping("/showAddcustomer")
	public String showAddcustomer() {
		return "customer/add_customer";
	}

	@RequestMapping("/showlinkmanAdd")
	public String showlinkmanAdd() {
		return "customer/linkman_add";
	}

	@RequestMapping("/showactivitiesAdd")
	public String showactivitiesAdd() {
		return "customer/activities_add";
	}
	
	@RequestMapping("/showAddSalChance")
	public String showAddSalChance() {
		return "marketing/add_salchance";
	}
	

	@RequestMapping("/showcontr")
	public String showcontr() {
		return "reportforms/contr";
	}

	@RequestMapping("/showcons")
	public String showcons() {
		return "reportforms/cons";
	}
}
