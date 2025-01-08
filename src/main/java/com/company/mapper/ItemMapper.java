package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.ItemVO;

public interface ItemMapper {
	List<ItemVO> findAll();
	ItemVO findByIdx(long idx);
	
	int insert(ItemVO itemVO);
	int update(ItemVO itemVO);
	int reduceItemQuantity(
		@Param("idx") long idx,
		@Param("quantity") int quantity
	);
	int delete(ItemVO itemVO);
	
	
	
}
