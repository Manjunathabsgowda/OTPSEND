package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Applicant;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.OtpService;
import com.example.demo.Service.RegisterService;

@RestController
public class RegisterController {
	@Autowired
    private OtpService otpService;
	 private Map<String, Boolean> otpVerificationMap = new HashMap<>();
	   @Autowired
	    private EmailService emailService;
	   @Autowired
	     RegisterService regsiterService;

	   @PostMapping("/applicant/sendotp")
	    public ResponseEntity<String> sendOtp(@RequestBody Applicant  request) {
	        String userEmail = request.getEmail();
	        Applicant applicant = regsiterService.findByEmailAddress(userEmail);
	        if (applicant == null) {     
	            String otp = otpService.generateOtp(userEmail);
	         	            emailService.sendOtpEmail(userEmail, otp);
	 	            otpVerificationMap.put(userEmail, true);
	 	            return ResponseEntity.ok("OTP sent to your email.");
	        }

	        else {
	        	 return ResponseEntity.badRequest().body("Email is already  registered.");
	        }
	    }
}
