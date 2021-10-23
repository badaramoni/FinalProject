package com.designpatterns.laptop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.designpatterns.laptop.model.LapTopInfo;

public interface DataRespository extends MongoRepository<LapTopInfo, String> {
 
	List<LapTopInfo> findByBrand(String brand);
  
}
