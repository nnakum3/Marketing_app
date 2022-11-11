package com.marketing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketing.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {
public List<Lead> findByfirstName(String firstName);
public List<Lead> findByFirstNameAndEmail(String firstName , String email);
}
