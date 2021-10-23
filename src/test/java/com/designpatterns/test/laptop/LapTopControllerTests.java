package com.designpatterns.test.laptop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.designpatterns.laptop.controller.LapTopController;

@ExtendWith(MockitoExtension.class)
class LapTopControllerTests {
	
	@InjectMocks
	LapTopController laptopController;

	@Test
	public void testoperateHigh() {

		ResponseEntity<String> responseEntity = laptopController.operateHigh("Production Server");

		assert(responseEntity.getStatusCode().is2xxSuccessful());
	}
	

	@Test
	public void testOperateOff() {
		
		ResponseEntity<String> responseEntity = laptopController.operateOff("Training Server");

		assert(responseEntity.getStatusCode().is2xxSuccessful());

	}

}
