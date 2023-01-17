package com.fam.sur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fam.sur.entity.Surveillance;
import com.fam.sur.service.SurveillanceService;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class SurveillanceController {

	@Autowired
	private SurveillanceService survService;
	
	@PostMapping("/surv/add")
	public ResponseEntity<Object> addSurveillance(@RequestBody Surveillance surv){
		Surveillance surveillance =  survService.addSurveillance(surv);
		return new ResponseEntity<>(surveillance, HttpStatus.CREATED);
	}
	
	@GetMapping("/surv/login/{employeeId}/{password}")
	public ResponseEntity<Object> surveillanceLogin(@PathVariable long employeeId, @PathVariable String password) {
		Surveillance surv = survService.survLogin(employeeId, password);
		return new ResponseEntity<>(surv, HttpStatus.OK);
	}
	
	@PutMapping("/surv/update")
	public ResponseEntity<Object> updateSurveillance(@RequestBody Surveillance surv){
		Surveillance surveillance =  survService.updateSurveillance(surv);
		return new ResponseEntity<>(surveillance, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/surv/delete/{employeeId}")
	public ResponseEntity<Object> deleteSurveillance(@PathVariable long employeeId){
		survService.deleteSurveillance(employeeId);
		return new ResponseEntity<>("Surveillance Deleted Successfully", HttpStatus.CREATED);
	}
	@GetMapping("/surv/{id}")
    public ResponseEntity<Object> getSurveillanceById(@PathVariable long id) {
        Surveillance surveillance =  survService.getSurveillanceById(id);
        return new ResponseEntity<>(surveillance, HttpStatus.OK);
    }

    @GetMapping("/surv/all")
    public ResponseEntity<Object> getAllSurveillance() {
        List<Surveillance> surveillanceList =  survService.getAllSurveillance();
        return new ResponseEntity<>(surveillanceList, HttpStatus.OK);
    }
}
