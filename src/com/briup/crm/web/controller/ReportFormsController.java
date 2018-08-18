package com.briup.crm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.jfree.data.category.CategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.common.util.JFreeChartUtil;
import com.briup.crm.service.interfaces.IReportFormsService;

@Controller
@RequestMapping("/reporforms")
public class ReportFormsController {

	@Autowired
	private IReportFormsService reportFormsService;

	@RequestMapping("/contr")
	public String getcstcon(String cstname, HttpServletRequest request) {
		try {
			CategoryDataset dataset = reportFormsService.findCstcontribute(cstname);

			// 保存图片 返回图片文件名
			String fileName = JFreeChartUtil.createBarChart("客户贡献分析表","客户","金额",dataset, request);
			// 获取图片路径（内存中） 需要在web.xml中配置一下
			String chartURL = request.getContextPath() + "/jfreeChart?filename=" + fileName;
			request.getSession().setAttribute("chartURL", chartURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "reportforms/contr";
	}

	@RequestMapping("/cons")
	public String getcons(int condit, HttpServletRequest request) {
		try {
			CategoryDataset dataset = reportFormsService.findCstMakeup(condit);
			String title = "";
			if (condit == 0) {
				title = "客户级别百分比分析表";
			} else if (condit == 1) {
				title = "客户信誉度分析表";
			} else if (condit == 2) {
				title = "客户满意度分析表";
			}
			// 保存图片 返回图片文件名
			String fileName = JFreeChartUtil.createBarChart(title,"客户类型", "百分比",dataset, request);
			// 获取图片路径（内存中） 需要在web.xml中配置一下
			String chartURL = request.getContextPath() + "/jfreeChart?filename=" + fileName;
			request.getSession().setAttribute("charturl", chartURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "reportforms/cons";
	}

}
