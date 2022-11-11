package com.marketing;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

@SpringBootTest
class Marketingapp1ApplicationTests {

	@Autowired
	LeadRepository leadrepo;
	
	@Test
	void saveOneLeads() {
		Lead l1 = new Lead();
		l1.setFirstName("nayan");
		l1.setLastName("nakum");
		l1.setEmail("nnakum3@gmail.com");
		l1.setMobile(8000281877L);
		
		leadrepo.save(l1);
	}
	@Test
	void findOneid() {
//		Optional<Lead> optional = leadrepo.findById(2L);
//		Lead lead = optional.get();
//		lead.setFirstName("shantnu");
//		Lead save = leadrepo.save(lead);
//		System.out.println(save);
		
			//FIND BY NAME
		
//		List<Lead> findByName = leadrepo.findByfirstName("kabootar");
//		findByName.forEach(lead->System.out.println(lead));
		
		// FIND BY NAME AND EMAIL
		
		List<Lead> findByFirstNameAndEmail = leadrepo.findByFirstNameAndEmail("nayan", "nnakum3@gmail.com");
		findByFirstNameAndEmail.forEach(e->System.out.println(e));
	}
	

}
