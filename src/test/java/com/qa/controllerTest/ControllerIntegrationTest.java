package com.qa.controllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entity.Airport;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ControllerIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void AddToAirport() throws Exception {
	
		Airport aeroplane1 = new Airport("Boeing 737-700", 149, 89.1f);
		String aeroplane1Json = this.mapper.writeValueAsString(aeroplane1);	
				
		Airport Savedaeroplane1 = new Airport(1, "Boeing 737-700", 149, 89.1f);
		String Savedaeroplane1Json = this.mapper.writeValueAsString(Savedaeroplane1);	
		
		
		RequestBuilder request =  post("/addToAirport").contentType(MediaType.APPLICATION_JSON).content(aeroplane1Json);
		
		ResultMatcher status = status().isCreated();
		ResultMatcher content = content().json(Savedaeroplane1Json);
	
		
		this.mvc.perform(request).andExpect(status).andExpect(content); 
		
	}
	
}
