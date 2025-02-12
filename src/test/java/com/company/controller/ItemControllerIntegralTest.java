package com.company.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.company.domain.ItemVO;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml",
	"file:src\\main\\webapp\\WEB-INF\\spring\\appServlet\\servlet-context.xml"
})
@Log4j
public class ItemControllerIntegralTest {
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testList() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/item"))
				.andExpect(status().isOk())
				.andReturn();
	
		String contentType = result.getResponse().getContentType();
		assertThat(contentType).contains("application/json");
		String responseBody = result.getResponse().getContentAsString();
		assertThat(responseBody).isNotEmpty();
	}
	
	@Test
	public void testIntegralCRUD() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		ItemVO itemVO = testItem();
		String itemJson = objectMapper.writeValueAsString(itemVO);
		
		MvcResult postResult = mockMvc.perform(
			post("/api/item")
			.contentType(MediaType.APPLICATION_JSON)
			.content(itemJson))
		.andExpect(status().isCreated())
		.andReturn();
		String responseBody = postResult.getResponse().getContentAsString();
        long createdItemId = Long.parseLong(responseBody);
        assertThat(createdItemId).isPositive();
        
        
        
        mockMvc.perform(get("/api/item/{id}", createdItemId))
        	.andExpect(status().isOk())
        	.andExpect(content().contentTypeCompatibleWith("application/json"))
        	.andReturn();
        
        itemVO.setIdx(createdItemId);
        itemVO.setShortDesc("MODIFIED");
        itemVO.setLongDesc("modified");
        
        
        
        mockMvc.perform(put("/api/item/{id}", createdItemId)
        	.contentType(MediaType.APPLICATION_JSON)
        	.content(objectMapper.writeValueAsString(itemVO)))
        .andExpect(status().isOk())
        .andReturn();
	}
	
	private ItemVO testItem() {
		ItemVO itemVO = new ItemVO();
		itemVO.setName("Oh TEST");
		itemVO.setBaseImgUrl("202501_SLASH_TEST");
		itemVO.setShortDesc("short short short");
		itemVO.setLongDesc("LONG");
		itemVO.setOriginalPrice(300200);
		itemVO.setPrice(100000);
		itemVO.setStock(55);
		itemVO.setProviderIdx(1);
		// assume that provider 1 exists, which is generated by sql
		return itemVO;
	}
}
