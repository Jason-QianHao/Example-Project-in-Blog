package com.jason.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jason.dao.ElasticDao;
import com.jason.document.Item;

@Service
public class ElasticsearchService {
	
	@Autowired
	private ElasticDao elasticDao;
	
	/*
	 * 插入
	 */
	public void add(Item item) {
		elasticDao.deleteAll();
	    // 接收对象集合，实现批量新增
	    elasticDao.save(item);
	}
	
	/*
	 * 批量插入
	 */
	public void add(List<Item> list) {
		elasticDao.deleteAll();
		elasticDao.saveAll(list);
	}
	
	/*
	 * 模糊查询
	 */
	public String queryByKeywords(String keyword) {
	    List<Item> list = elasticDao.findByTitleLike(keyword);
	    return JSON.toJSONString(list);
	}
}
