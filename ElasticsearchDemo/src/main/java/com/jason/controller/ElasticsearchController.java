package com.jason.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jason.document.Item;
import com.jason.service.ElasticsearchService;

@RestController
public class ElasticsearchController {

	@Autowired
	private ElasticsearchService elasticsearchService;
	
	/*
	 * 插入
	 */
	@RequestMapping("/add")
	public String add() {
		Item item = new Item(2L, "iphone13", "iphone", 3699.00, "http://xxx/1.jpg");
		Item item2 = new Item(3L, "iphone12", "iphone", 4499.00, "http://xxx/1.jpg");
	    try {
			elasticsearchService.add(item);
			return "Successfully";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/*
	 * 批量插入
	 */
	@RequestMapping("/addBatch")
	public String addBatch() {
	    List<Item> list = new ArrayList<>();
	    list.add(new Item(1L, "小米手机7", "小米", 3299.00, "http://xxx/1.jpg"));
	    list.add(new Item(2L, "坚果手机R1", "锤子", 3699.00, "http://xxx/1.jpg"));
	    list.add(new Item(3L, "华为META10", "华为", 4499.00, "http://xxx/1.jpg"));
	    list.add(new Item(4L, "小米Mix2S", "小米", 4299.00, "http://xxx/1.jpg"));
	    list.add(new Item(5L, "荣耀V10", "华为", 2799.00, "http://xxx/1.jpg"));
	    try {
			elasticsearchService.add(list);
			return "Successfully";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/*
	 * 根据关键词查询
	 */
	@RequestMapping("/query")
	public String queryBykeywords(String keywords) {
		try {
			return elasticsearchService.queryByKeywords(keywords); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Query Failed";
		}
	}
}
