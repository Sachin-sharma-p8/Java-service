package com.demo.project;

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface JsonDataRepository extends JpaRepository<JsonData, Long> {
} 