package com.collabera.material.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.material.model.Item;

@Repository
public interface MaterialRepository extends JpaRepository<Item, Long> {

} 


