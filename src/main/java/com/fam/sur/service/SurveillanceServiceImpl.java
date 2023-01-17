package com.fam.sur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fam.sur.entity.Surveillance;
import com.fam.sur.exception.PasswordDoesNotMatchException;
import com.fam.sur.exception.UserNotFoundException;
import com.fam.sur.repository.SurveillanceRepository;

@Service
public class SurveillanceServiceImpl implements SurveillanceService{

	@Autowired
	private SurveillanceRepository survRepo;

	@Override
	public Surveillance addSurveillance(Surveillance surv) {
		return survRepo.save(surv);
	}

	@Override
	public Surveillance survLogin(long employeeId, String password) {
		Optional<Surveillance> optSurv = survRepo.findById(employeeId);
		
		if(optSurv.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}
		
		Surveillance surv = optSurv.get();
		
		if(!surv.getPassword().equals(password)) {
			throw new PasswordDoesNotMatchException("Password not matched");
		}
		
		return surv;
	}

	@Override
	public Surveillance updateSurveillance(Surveillance surv) {
		Optional<Surveillance> optSurv = survRepo.findById(surv.getId());
		
		if(optSurv.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}
		
		return survRepo.save(surv);
	}

	@Override
	public boolean deleteSurveillance(long employeeId) {
		Optional<Surveillance> optSurv = survRepo.findById(employeeId);
		
		if(optSurv.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}
		
		survRepo.deleteById(employeeId);
		
		return false;
	}
	
	@Override
    public Surveillance getSurveillanceById(long id) {
        Surveillance surveillance = survRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
        return surveillance;
    }

 

    @Override
    public List<Surveillance> getAllSurveillance() {
        return survRepo.findAll();
    }
}
