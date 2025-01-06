package com.company.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PurchaseVO {
	long idx;
	long buyerIdx;
	Timestamp purchaseTime;
	boolean canceled;
	long amount;
	
	List<PurchaseItemDTO> purchaseItems; 
}
