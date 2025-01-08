package com.company.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString 
public class ItemVO {
	long idx;
	String name;
	String baseImgUrl;
	String shortDesc;
	String longDesc;
	int originalPrice;
	int price;
	
	Date regDate;
	int stock;
	long providerIdx;
	boolean deleted;
	
	public ItemVO() {}
	public ItemVO(ItemVO original) {
		this.idx = original.idx;
		this.name = original.name;
		this.baseImgUrl = original.baseImgUrl;
		this.shortDesc = original.shortDesc;
		this.longDesc = original.longDesc;
		this.originalPrice = original.originalPrice;
		this.price = original.price;
		this.regDate = new Date(original.regDate.getTime());
		this.stock = original.stock;
		this.providerIdx = original.providerIdx;
		this.deleted = original.deleted;
	}
	
	
}
