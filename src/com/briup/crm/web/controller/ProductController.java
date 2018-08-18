package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.bean.Product;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.service.interfaces.IBasicDataService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IBasicDataService basicDataService;

	@RequestMapping("/{curpage}/findAllProduct")
	public String findAllProduct(@PathVariable int curpage, HttpSession session) {
		try {
			PageInfo<Product> pageInfo = basicDataService.findProductAll(curpage, 5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "basicdata/product";
	}
	
	@RequestMapping("/{curpage}/findProductByCon")
	public String findProductByCon(@PathVariable int curpage,Product product, HttpSession session) {
		try {
			PageInfo<Product> pageInfo = basicDataService.findProduct(product, curpage, 5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		return "basicdata/product";
	}
}
