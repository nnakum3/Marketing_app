package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entity.Lead;
import com.marketing.services.LeadService;
import com.marketing.util.EmailService;
import com.marketing.util.EmailServiceImpl;

@Controller
public class LeadController {

	@Autowired
	private EmailService emailService;
	
	//handler methods
	@Autowired
	private LeadService leadService;
	
	//   http:localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLeadPage() {
		return"create_lead";
	}
	
	@RequestMapping("/saveLeads")
	public String saveOneLeads(@ModelAttribute("l") Lead lead, ModelMap model) {
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(), "welcome ", "Test Email from nyn");
		model.addAttribute("msg", "record is saved");
		return"create_lead";
	}
	
//	@RequestMapping("/saveLeads")
//	public String saveOneLeads(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,@RequestParam("email")String email,@RequestParam("mobile")long mobile, ModelMap model) {
//		Lead lead = new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		
//		leadService.saveLead(lead);
//		
//		
//		model.addAttribute("msg", "record is saved");
//		return "create_lead";
//	}
//	
	
//	@RequestMapping("/saveLeads")
//	public String saveOneLeads(LeadData leadData, ModelMap model) {
//		Lead lead = new Lead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setEmail(leadData.getEmail());
//		lead.setMobile(lead.getMobile());
//		
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "record is saved");
//		return "create_lead";
//		
//		
//}
	// http://localhost:3306/listAll
	@RequestMapping("/listAll")
	public String listAllLeads( Model model){
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id")long id , Model model) {
		leadService.deleteOneLead(id);
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/update")
	public String getOneLead(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.getoneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateOneLead(LeadData data, Model model) {
		Lead l = new Lead();
		l.setId(data.getId());
		l.setFirstName(data.getFirstName());
		l.setLastName(data.getLastName());
		l.setEmail(data.getEmail());
		l.setMobile(data.getMobile());
		
		leadService.saveLead(l);
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
		
	}
}




















