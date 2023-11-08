package com.example.demo.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Applicant;

public interface RegisterRepositary extends JpaRepository<Applicant, Long>{
	Applicant  findByEmail(String email);

	boolean existsByEmail(String email);
}
