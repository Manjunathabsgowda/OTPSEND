package com.example.demo.Service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class OtpService {
	private static final long OTP_VALID_DURATION_MS = 120 * 1000; // 120 seconds

    private Map<String, OtpData> otpMap = new HashMap<>();

    public String generateOtp(String userEmail) {
        String otp = generateRandomOtp();
        otpMap.put(userEmail, new OtpData(otp));
        return otp;
    }
    private String generateRandomOtp() {
        return RandomStringUtils.randomNumeric(6); // Generate a 6-digit OTP
    }
    //
    private static class OtpData {
        private String otp;
        private long creationTime;

        public OtpData(String otp) {
            this.otp = otp;
            this.creationTime = System.currentTimeMillis();
        }

        public long getCreationTime() {
            return creationTime;
        }
    }
}
