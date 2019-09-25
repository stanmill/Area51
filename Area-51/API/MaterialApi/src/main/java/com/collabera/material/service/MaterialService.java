package com.collabera.Item.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class ItemService {
	
	private final ItemRepo Repo;
	private final Mapper Map;
	
	public ItemService(ItemRepo repo, Mapper mapper) {
		super();
		Repo = repo;
		this.mapper = mapper;
	}
	
public List<ItemDto> findAll() {
		
		return Repo.findAll().stream().map(m -> Map.toDto(m)).collect(Collectors.toList());
		
	}
	
	public ItemDto findById(int id) {
		Optional<Item> mats = Repo.findById(id);
		if (fateOp.isPresent()) {
			return Map.toDto(mats.get());
		}
		return null;
	}

	public ItemDto save(ItemDto mats) {
		Item entity = Map.toEntity(mats);
		Item saved = Repo.save(entity);
		return Map.toDTO(saved);
	}

	public ItemDto update(ItemDto hero) {
		int id = hero.getId();
		Optional<Item> findById = Repo.findById(id);
		if (findById.isPresent()) {
			Item updatedMats = findById.get();
			updatedMats.setNo.(hero.getName());
			updatedMats.setName(hero.getName());
			updatedMats.setImage(hero.getImage());
			updatedMats.setCost(hero.getCost());
			Item saved = Repo.save(updatedMats);
			return Map.toDto(saved);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void deleteById(int id) {
		Repo.deleteById(id);
	}
	
}

}
