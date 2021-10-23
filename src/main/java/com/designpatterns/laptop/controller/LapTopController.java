package com.designpatterns.laptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.designpatterns.laptop.model.LapTopInfo;
import com.designpatterns.laptop.service.LapTopService;
import com.designpatterns.laptop.utils.LapTopHighCommand;
import com.designpatterns.laptop.utils.LapTopMediumCommand;
import com.designpatterns.laptop.utils.LapTopOffCommand;
import com.designpatterns.laptop.utils.LapTopUtils;

@RestController
@RequestMapping("/api")
public class LapTopController {

	@Autowired
	LapTopService laptopService;

	@GetMapping("/operateLapTopHighMemory/{location}")
	public ResponseEntity<String> operateHigh(@PathVariable("location") String location) {

			LapTopUtils FanUtils = new LapTopUtils(location);
			LapTopHighCommand laptopHigh = new LapTopHighCommand(FanUtils);
			laptopHigh.execute();
			return new ResponseEntity<String>("  laptop is on high memory at  " + location, HttpStatus.OK);
	}

	@GetMapping("/operateLapTopMediumMemory/{location}")
	public ResponseEntity<String> operateMedium(@PathVariable("location") String location) {

			LapTopUtils FanUtils = new LapTopUtils(location);
			LapTopMediumCommand laptopMedium = new LapTopMediumCommand(FanUtils);
			laptopMedium.execute();
			return new ResponseEntity<String>("  laptop is on medium memory at  " + location, HttpStatus.OK);
	}

	
	@GetMapping("/operateLapTopLowMemory/{location}")
	public ResponseEntity<String> operateOff(@PathVariable("location") String location) {

			LapTopUtils laptopUtils = new LapTopUtils(location);
			LapTopOffCommand laptopOff = new LapTopOffCommand(laptopUtils);
			laptopOff.execute();
			return new ResponseEntity<String>("  laptop is on low memory at  " + location, HttpStatus.OK);
	}
	

	@GetMapping("/getAllLapTopDetails")
	public ResponseEntity<List<LapTopInfo>> getMapData(){
		try {
			List<LapTopInfo> getDataList =  laptopService.getMapData();
			if (getDataList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(getDataList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/getlaptopByName/{brand}")
	public ResponseEntity<List<LapTopInfo>> getValueByKey(@PathVariable("brand") String brand) {

		try { 
			List<LapTopInfo> fData = laptopService.getValueByKey(brand);
			if ( fData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} 
			return new ResponseEntity<>( fData, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/insertNewLapTopDetails")
	public ResponseEntity<LapTopInfo> createCountry(@RequestBody LapTopInfo cfData) {
		try {
			LapTopInfo _createEntry = laptopService.createMapEntry(new LapTopInfo(cfData.getId(),cfData.getBrand(), cfData.getLaptopColor(), cfData.getPrice()));
			if(null!= _createEntry) {
				return new ResponseEntity<>(_createEntry, HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateLapTopDetails/{id}")
	public ResponseEntity<LapTopInfo> updateEntry(@PathVariable("id") String id, @RequestBody LapTopInfo datatoUpdate) {

		LapTopInfo updatedData = laptopService.updateEntry(id,datatoUpdate);
		if(null!= updatedData) {
			return new ResponseEntity<>(updatedData, HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteLaptop/{id}")
	public ResponseEntity<HttpStatus> deleteEntry(@PathVariable("id") String id) {
		try {
			laptopService.deleteEntry(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<HttpStatus> deleteEntries() {
		try {
			laptopService.deleteEntries();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
