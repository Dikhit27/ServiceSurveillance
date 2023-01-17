package com.fam.sur.service;

import java.util.List;

import com.fam.sur.entity.Surveillance;

public interface SurveillanceService {

	public Surveillance addSurveillance(Surveillance surv);
	
	public Surveillance survLogin(long employeeId, String password);
	
	public Surveillance updateSurveillance(Surveillance surv);
	
	public boolean deleteSurveillance(long employeeId);

	Surveillance getSurveillanceById(long id);

	List<Surveillance> getAllSurveillance();
	
}
