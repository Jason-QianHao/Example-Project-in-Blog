package com.jason.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.jason.document.Item;

public interface ElasticDao extends ElasticsearchRepository<Item, Long> {
	
	List<Item> findByTitleLike(String keywords);
	
	List<Item> findByBrandLike(String keywords);

}
