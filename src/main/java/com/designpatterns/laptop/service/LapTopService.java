package com.designpatterns.laptop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.designpatterns.laptop.model.LapTopInfo;
import com.designpatterns.laptop.repository.DataRespository;


@Service
public class LapTopService {

	@Autowired
	DataRespository dataRepository;

	
	public List<LapTopInfo>  getMapData(){
		List<LapTopInfo> getDataList = new ArrayList<LapTopInfo>();
		dataRepository.findAll().forEach(getDataList::add);
		System.out.println(" fetching from datastore");
		return getDataList;
	}
	
	
	public List<LapTopInfo>  getValueByKey(@PathVariable("brand") String brand) {
		List<LapTopInfo> dataList = new ArrayList<LapTopInfo>();
		dataRepository.findByBrand(brand).forEach(dataList::add);;
		System.out.println(" fetching from datastore");
		return dataList;
	}

	
	public LapTopInfo createMapEntry(@RequestBody LapTopInfo laptopInfo) {
		LapTopInfo createMapEntry = null;
		if(dataRepository.findByBrand(laptopInfo.getBrand()).isEmpty()) {
			createMapEntry = dataRepository.save(new LapTopInfo(laptopInfo.getId(),laptopInfo.getBrand(), laptopInfo.getLaptopColor(),laptopInfo.getPrice()));
		}
		System.out.println(" fetching from datastore");
		return createMapEntry;
	}


	/**
	 * updateLaptop
	 * @param id
	 * @param laptopInfo
	 * @return laptopCrossreferenceData
	 */
	public LapTopInfo updateEntry(@PathVariable("id") String id, @RequestBody LapTopInfo laptopInfo) {
		Optional<LapTopInfo> mapData = dataRepository.findById(id);
		LapTopInfo cfData = null;
		if (mapData.isPresent()) {
			cfData = mapData.get();
			cfData.setBrand(laptopInfo.getBrand());
			cfData.setLaptopColor(laptopInfo.getLaptopColor());
			cfData.setPrice(laptopInfo.getPrice());
		}
		System.out.println(" fetching from datastore");
		return cfData;
	}

	/**
	 * delete laptop by id
	 * @param id
	 */
	public void deleteEntry(@PathVariable("id") String id) {
		System.out.println(" fetching from datastore");
		dataRepository.deleteById(id);
	}

	/**
	 * delete all laptops
	 */
	public void deleteEntries() {
		dataRepository.deleteAll();
	}

}
