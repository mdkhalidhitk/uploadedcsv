package com.mb.service.car.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mb.service.car.helper.ResponseMessage;
import com.mb.service.car.model.Consumer;


@RequestMapping("/v1/carserviec")
public interface CarServiceController {
	
	
	@GetMapping("/getSuccess")
	public String returnValue();
	
	 @PostMapping("/upload")
	 public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) ;
	 
	  @GetMapping("/consumers")
	  public ResponseEntity<List<Consumer>> getAllConsumer();

}
