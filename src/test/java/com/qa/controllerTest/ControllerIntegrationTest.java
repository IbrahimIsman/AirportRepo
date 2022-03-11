package com.qa.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entity.Airport;

@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = {"classpath:airport-schema.sql","classpath:airport-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
public class ControllerIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void AddToAirportTest() throws Exception {
	
		Airport aeroplane1 = new Airport(null, "Boeing 737-700", 149, 89.1f);
		String aeroplane1Json = this.mapper.writeValueAsString(aeroplane1);	
				
		Airport Savedaeroplane1 = new Airport(4, "Boeing 737-700", 149, 89.1f);
		String Savedaeroplane1Json = this.mapper.writeValueAsString(Savedaeroplane1);	
		
		
		RequestBuilder request =  post("/addToAirport").contentType(MediaType.APPLICATION_JSON).content(aeroplane1Json);
		
		ResultMatcher status = status().isCreated();
		ResultMatcher content = content().json(Savedaeroplane1Json);
	
		
		this.mvc.perform(request).andExpect(status).andExpect(content); 
		
	}
	
	@Test
	void getAllTest() throws Exception {

		List<Airport> airportTable = new ArrayList();
		airportTable.add(new Airport(1, "Boeing 737-700", 149, 89.1f));
		airportTable.add(new Airport(2, "Boeing 737 MAX 7", 172, 106.1f));
		airportTable.add(new Airport(3, "Boeing 737-800", 189 , 89.1f));
		String airportTableJson = this.mapper.writeValueAsString(airportTable);
	
		RequestBuilder request = get("/getAll");
		ResultMatcher status = status().isOk();
		ResultMatcher content = content().json(airportTableJson);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	
	@Test
	void getByIdTest() throws Exception {
		
		Airport aeroplane = new Airport(1, "Boeing 737-700", 149, 89.1f);
		String aeroplaneJson = this.mapper.writeValueAsString(aeroplane);
	
		RequestBuilder request = get("/getById/1");
		ResultMatcher status = status().isOk();
		ResultMatcher content = content().json(aeroplaneJson);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	
	@Test
	void findByCapacity() throws Exception {
		
		List<Airport> airportTable = new ArrayList();
		airportTable.add(new Airport(1, "Boeing 737-700", 149, 89.1f));
		String airportTableJson = this.mapper.writeValueAsString(airportTable);
		
		RequestBuilder request = get("/findByCapacity/149");
		ResultMatcher status = status().isOk();
		ResultMatcher content = content().json(airportTableJson);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
		
	}
	
	@Test 
	void deleteTest() throws Exception {
		this.mvc.perform(delete("/delete/1")).andExpect(status().isAccepted());
	}
	
	@Test 
	void updateTest() throws Exception {
		
		Airport updatedPlane = new Airport(1, "Boeing 737-700", 160, 89.1f);
		String updatedPlaneJson = this.mapper.writeValueAsString(updatedPlane);
		
		RequestBuilder request = put("/update/1").contentType(MediaType.APPLICATION_JSON).content(updatedPlaneJson);
		
		ResultMatcher status = status().isAccepted();
		ResultMatcher content = content().json(updatedPlaneJson);
	
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	
	
	
}
