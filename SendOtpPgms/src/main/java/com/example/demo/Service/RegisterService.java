package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Applicant;
import com.example.demo.Repositary.RegisterRepositary;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterRepositary regrepo;

	public Applicant findByEmailAddress(String userEmail) {

		return regrepo.findByEmail(userEmail);

	}

}
