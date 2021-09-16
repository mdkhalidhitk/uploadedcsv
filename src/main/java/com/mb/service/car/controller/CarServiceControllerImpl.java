package com.mb.service.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mb.service.car.helper.CSVHelper;
import com.mb.service.car.helper.ResponseMessage;
import com.mb.service.car.model.Consumer;
import com.mb.service.car.service.CSVService;

@RestController
@CrossOrigin("http://localhost:8080")
public class CarServiceControllerImpl implements CarServiceController {

	@Autowired
	CSVService fileService;

	@Override
	public String returnValue() {

		return "Succes for uploading";
	}

	@Override
	public ResponseEntity<ResponseMessage> uploadFile(MultipartFile file) {

		String message = "";

		if (CSVHelper.hasCSVFormat(file)) {
			try {
				fileService.save(file);

				message = "Uploaded CSV file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: "+e.getMessage()+"---------" + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

	@Override
	public ResponseEntity<List<Consumer>> getAllConsumer() {
		try {
			List<Consumer> tutorials = fileService.getAllTutorials();

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
