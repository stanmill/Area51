package com.collabera.material.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.collabera.material.itemdto.ItemDto;
import com.collabera.material.mapper.ItemMapper;
import com.collabera.material.model.Item;
import com.collabera.material.repository.MaterialRepository;


@Service
@Transactional
public class MaterialService {
	
	private final MaterialRepository Repo;
	private final ItemMapper Map;
	
	public MaterialService(MaterialRepository repo, ItemMapper mapper) {
		super();
		Repo = repo;
		this.Map = mapper;
	}
	
	public List<ItemDto> findAll() {
		
		return Repo.findAll().stream().map(m -> Map.toDto(m)).collect(Collectors.toList());
		
	}
	
	public ItemDto findById(Long id) {
		Optional<Item> mats = Repo.findById(id);
		if (mats.isPresent()) {
			return Map.toDto(mats.get());
		}
		return null;
	}

	public ItemDto save(ItemDto mats) {
		Item entity = Map.toEntity(mats);
		Item saved = Repo.save(entity);
		return Map.toDto(saved);
	}

	public ItemDto update(ItemDto mats) {
		Long id = mats.getId();
		Optional<Item> findById = Repo.findById(id);
		if (findById.isPresent()) {
			Item updatedMats = findById.get();
			updatedMats.setNum(mats.getNumOfItems());
			updatedMats.setName(mats.getName());
			updatedMats.setPicture(mats.getPicture());
			updatedMats.setCost(mats.getCost());
			Item saved = Repo.save(updatedMats);
			return Map.toDto(saved);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void deleteById(Long id) {
		Repo.deleteById(id);
	}
	
}
