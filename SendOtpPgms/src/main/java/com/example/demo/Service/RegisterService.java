package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Applicant;
import com.example.demo.Repositary.RegisterRepositary;

@Service
public class RegisterService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RegisterRepositary regrepo;

	public Applicant findByEmailAddress(String userEmail) {

		return regrepo.findByEmail(userEmail);

	}
	
	public ResponseEntity<String> saveapplicant(Applicant applicant) {

	     if (regrepo.existsByEmail(applicant.getEmail())) {
	         return ResponseEntity.badRequest().body("Email already registered");

	     }

	   	     applicant.setPassword(passwordEncoder.encode(applicant.getPassword()));
	        	     regrepo.save(applicant);
	     return ResponseEntity.ok("Applicant registered successfully");

	}


}
