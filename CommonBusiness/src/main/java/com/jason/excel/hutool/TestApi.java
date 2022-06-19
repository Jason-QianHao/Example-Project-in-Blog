package com.jason.excel.hutool;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.excel.domain.Excel;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

@Controller
public class TestApi {

	/**
	 * 输出到本地
	 * 
	 * @return
	 */
	@RequestMapping("/excel1")
	@ResponseBody
	public String excel1() {
		List<Excel> list = init();
		/*
		 * 这里可以获取到target/classes/文件目录，但是我这里有中文，没办法解析 String path =
		 * this.getClass().getResource("/").getPath(); String filepath = path +
		 * "../../excel/test.xlsx";
		 */
		// 通过工具类创建writer
		ExcelWriter writer = ExcelUtil
				.getWriter("/Users/qianhao/Jason/个人学习/Blog/Code/Eclipse/CommonBusiness/excel/test.xlsx");
		// 合并单元格后的标题行，使用默认标题样式
		writer.merge(4, "一班成绩单");
		// 一次性写出内容，使用默认样式，强制输出标题
		writer.write(list, true);
		// 关闭writer，释放内存
		writer.close();
		return "success";
	}

	/**
	 * 输出到浏览器
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/excel2")
	public void excel2(HttpServletResponse response) throws IOException {
		List<Excel> rows = init();
		ExcelWriter writer = ExcelUtil.getWriter(true);
		writer.write(rows, true);
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=test.xlsx");
		ServletOutputStream out = response.getOutputStream();
		writer.flush(out, true);
		writer.close();
		IoUtil.close(out);
	}

	private List<Excel> init() {
		Excel bean1 = new Excel();
		bean1.setName("张三");
		bean1.setAge(22);
		bean1.setPass(true);
		bean1.setScore(66.30);
		bean1.setExamDate(DateUtil.date());

		Excel bean2 = new Excel();
		bean2.setName("李四");
		bean2.setAge(28);
		bean2.setPass(false);
		bean2.setScore(38.50);
		bean2.setExamDate(DateUtil.date());

		List<Excel> rows = CollUtil.newArrayList(bean1, bean2);
		return rows;
	}
}
