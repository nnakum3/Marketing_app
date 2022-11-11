package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

@RestController
@RequestMapping("/rest")
public class LeadRestController {
	
	@Autowired
	LeadRepository leadRepo;
	
	@GetMapping
	public List<Lead> getLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
		
	}
}
