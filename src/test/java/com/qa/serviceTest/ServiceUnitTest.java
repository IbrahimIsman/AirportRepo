package com.qa.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.entity.Airport;
import com.qa.repo.AirportRepo;
import com.qa.service.AirportService;

@SpringBootTest
public class ServiceUnitTest {
    
	@Autowired
	private AirportService service;
	
	@MockBean
	private AirportRepo repo;
	
	@Test
	void addAeroplaneTest() {
	
	    Airport planeToSave = new Airport(null, "Boeing 737-700", 160, 89.1f);
	    Airport planeSaved = new Airport(1, "Boeing 737-700", 160, 89.1f);
	
	    Mockito.when(this.repo.save(planeToSave)).thenReturn(planeSaved);

	    assertThat(this.service.addAeroplane(planeToSave)).isEqualTo(planeSaved);
	
	    Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Airport.class));
	
	}
	
	@Test 
	void getAllTest() {
		
		int id =1;
		Airport plane = new Airport(null, "Boeing 737-700", 160, 89.1f);
		plane.setId(id);
		List<Airport> planes = List.of(plane);
		
		Mockito.when(this.repo.findAll()).thenReturn(planes);
		
		Assertions.assertThat(this.service.getAll()).isEqualTo(planes);
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	
	@Test
	void getByIdTest() {
	
		int id =1;
		Airport plane = new Airport(1, "Boeing 737-700", 160, 89.1f);
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(plane));
		
		assertThat(this.service.getById(id)).isEqualTo(plane);
	
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyInt());
	}
	

	@Test
	void deleteTest() {
		int id = 1;
		
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		
		Assertions.assertThat(this.service.delete(id)).isTrue();
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(Mockito.anyInt());
		Mockito.verify(this.repo, Mockito.times(1)).existsById(Mockito.anyInt());
	}
	
	@Test
	void deleteTestFalse() {
		int id = 1;
		
		Mockito.when(this.repo.existsById(id)).thenReturn(true);
		
		Assertions.assertThat(this.service.delete(id)).isFalse();
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(Mockito.anyInt());
		Mockito.verify(this.repo, Mockito.times(1)).existsById(Mockito.anyInt());
	}
	
	
	@Test
	void getByCapacityTest() {
	
		int Capacity =149;
		Airport plane = new Airport(null, "Boeing 737-700", 149, 89.1f);
		plane.setCapacity(Capacity);
		List<Airport> planes = List.of(plane);
		
		Mockito.when(this.repo.findAirportByCapacitySQL(Capacity)).thenReturn(planes);
		
		Assertions.assertThat(this.service.findPlaneByCapacity(Capacity)).isEqualTo(planes);
	
		Mockito.verify(this.repo, Mockito.times(1)).findAirportByCapacitySQL(Mockito.anyInt());
	}
	
	@Test
	void updateTest() {
		int id =1;
		Airport plane = new Airport(1, "Boeing 737-700", 160, 89.1f);
		Airport planeBeforeUpdate = new Airport(null, "Boeing 737-700", 160, 89.1f);
		Airport planeAfterUpdate = new Airport(1, "Boeing 737-700", 160, 89.1f);
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(plane));
		Mockito.when(this.repo.save(planeAfterUpdate)).thenReturn(planeAfterUpdate);
		
		Assertions.assertThat(this.service.update(id, planeBeforeUpdate)).isEqualTo(planeAfterUpdate);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyInt());
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Airport.class));
	}
	
}



	

