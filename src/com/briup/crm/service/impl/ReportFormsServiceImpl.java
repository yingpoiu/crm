package com.briup.crm.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.common.bean.CstCustomer;
import com.briup.crm.common.bean.Orders;
import com.briup.crm.common.bean.OrdersExample;
import com.briup.crm.common.bean.OrdersLine;
import com.briup.crm.common.bean.OrdersLineExample;
import com.briup.crm.common.bean.OrdersLineExample.Criteria;
import com.briup.crm.common.exception.CrmCommonException;
import com.briup.crm.dao.OrdersLineMapper;
import com.briup.crm.dao.OrdersMapper;
import com.briup.crm.service.interfaces.ICustomerService;
import com.briup.crm.service.interfaces.IReportFormsService;

@Service
public class ReportFormsServiceImpl implements IReportFormsService  {
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private OrdersMapper ordersMapper; 
	
	@Autowired
	private OrdersLineMapper lineMapper;
	/**
	 * 客户贡献分析
	 * @throws UnsupportedEncodingException 
	 */
	@Override
	public CategoryDataset findCstcontribute(String custName) throws Exception {
		if (StringUtils.isBlank(custName)) {
			List<CstCustomer> customer = customerService.findAllCustomer();
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (CstCustomer cstCustomer : customer) {
				String name = cstCustomer.getCustName();
				dataset.addValue(OrderTotal(name), "客户贡献分析", name);
			}
			return dataset;
		} else {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			dataset.setValue(OrderTotal(custName), "客户贡献分析", custName);
			return dataset;
		}
	}
	
	public double OrderTotal(String custName) throws CrmCommonException {
		CstCustomer customer = customerService.findCustomerByCstName(custName);
		OrdersExample example = new OrdersExample();
		example.createCriteria().andOdrCustIdEqualTo(customer.getCustId());
		List<Orders> list = ordersMapper.selectByExample(example);
		double sum = 0;
		
		OrdersLineExample lineExample = new OrdersLineExample();
		Criteria criteria = lineExample.createCriteria();
		for (Orders orders : list) {
			criteria.andProdIdEqualTo(orders.getOdrId());
			List<OrdersLine> ordersLines = lineMapper.selectByExample(lineExample);
			lineExample.clear();
			for (OrdersLine ordersLine : ordersLines) {
				sum += ordersLine.getOddPrice();
			}
		}
		return sum;
	}
	/**
	 * 客户构成分析
	 */
	@Override
	public CategoryDataset findCstMakeup(int condit) throws CrmCommonException {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//总人数
		int count = customerService.findAllCustomer().size();
		//按等级构成
		if (condit == 0) {
			//查找出所有的等级
			Set<String> sets = customerService.findAllCustomerLevelLable();
			for (String string : sets) {
				int num = customerService.findCstCustomerByLevelLable(string).size();
				//百分比
				double per = (double)num / count;
				dataset.addValue(per, "客户等级百分比", string);
			}
		} else if (condit == 1) {
			//查找出所有的信誉度
			Set<Integer> credits = customerService.findAllCustomerCredit();
			for (Integer integer : credits) {
				int num = customerService.findCstCustomerByCredit(integer).size();
				//百分比
				double per2 = (double)num / count;
				System.out.println(per2);
				dataset.addValue(per2, "客户信用度百分比", integer);
			}
		} else if (condit == 2) {
			//查找出所有的信誉度
			Set<Integer> credits = customerService.findAllCustomerSatisfy();
			for (Integer integer : credits) {
				int num = customerService.findCstCustomerBySatisfy(integer).size();
				//百分比
				double per3 = (double)num / count;
				System.out.println(per3);
				dataset.addValue(per3, "客户信用度百分比", integer);
			}
		}
		return dataset;
	}

}

