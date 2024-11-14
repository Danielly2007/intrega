package com.teste.p.perfumerepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.qos.logback.core.model.Model;


public interface PerfumeRepository extends JpaRepository <Model, UUID> {

	
	}