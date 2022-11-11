package com.marketing.services;

import java.util.List;

import com.marketing.entity.Lead;

public interface LeadService {

	public void saveLead(Lead lead);

	public List<Lead> getLeads();

	public void deleteOneLead(long id);

	public Lead getoneLead(long id);
}
