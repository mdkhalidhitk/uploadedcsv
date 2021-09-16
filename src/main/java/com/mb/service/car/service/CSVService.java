package com.mb.service.car.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mb.service.car.helper.CSVHelper;
import com.mb.service.car.model.Consumer;
import com.mb.service.car.repositry.ConsumerRepositry;


@Service
public class CSVService {

	@Autowired
	ConsumerRepositry repository;
	public void save(MultipartFile file) {
	    try {
	      List<Consumer> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
	      
	      repository.saveAll(tutorials);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

	  public List<Consumer> getAllTutorials() {
	    return repository.findAll();
	  }
}
