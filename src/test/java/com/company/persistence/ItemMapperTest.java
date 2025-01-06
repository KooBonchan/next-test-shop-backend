package com.company.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.company.mapper.ItemMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
@Log4j
public class ItemMapperTest {
	@Autowired
	private ItemMapper mapper;
	
	@Test
	public void testRead() {
		var items = mapper.findAll();
		assertNotNull(items);
		assertTrue(items.size() > 0);
	}
	
	@Test
	@Transactional
	public void testCRUD() {
		
		
	}
}
