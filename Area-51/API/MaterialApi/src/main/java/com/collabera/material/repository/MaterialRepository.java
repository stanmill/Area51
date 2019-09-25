package com.collabera.material.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Material;

@Repository
public class MaterialRepository extends JpaRepository<Material, Long> {

} 


