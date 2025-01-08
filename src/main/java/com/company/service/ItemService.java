package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.ItemVO;
import com.company.mapper.ItemMapper;

@Service
public class ItemService {
	@Autowired
	private ItemMapper itemMapper;
	
	public boolean registerItem(ItemVO item) {
		return itemMapper.insert(item) > 0;
	}
	
	public List<ItemVO> getItem() {
		return itemMapper.findAll();
	}
	public ItemVO getItem(long idx){
		return itemMapper.findByIdx(idx);
	}
	
	public boolean updateItem(ItemVO item) {
		if(item.getIdx() <= 0 || item.getProviderIdx() <= 0) return false;
		if(item.getPrice() <= 0 || item.getStock() <= 0) return false;
		return itemMapper.update(item) > 0;
	}
}
