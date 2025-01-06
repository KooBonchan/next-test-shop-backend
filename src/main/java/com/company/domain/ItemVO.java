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
	int price;
	
	Date regDate;
	int stock;
	long providerIdx;
	boolean deleted;
}
