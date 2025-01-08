package com.company.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.domain.ItemVO;
import com.company.service.ItemService;

@RestController
@RequestMapping("api/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("")
	@ResponseBody
	public List<ItemVO> getItem() {
		return itemService.getItem();
	}
	
	@GetMapping("{idx}")
	@ResponseBody
	public ItemVO getItem(
		@PathVariable("idx") long idx
	) {
		return itemService.getItem(idx);
	}
	
	@PostMapping("")
	public ResponseEntity<Long> registerItem(
		@RequestBody ItemVO itemVO
	){
		if(itemService.registerItem(itemVO))
			return ResponseEntity.status(HttpStatus.CREATED).body(itemVO.getIdx());
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("{idx}")
	public ResponseEntity<Void> updateItem(
			@PathVariable("idx") long idx,
			@RequestBody ItemVO itemVO
	){
		if(itemService.updateItem(itemVO)) return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}
	
	
}
