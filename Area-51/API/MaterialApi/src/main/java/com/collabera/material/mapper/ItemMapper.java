package com.collabera.material.mapper;

import org.springframework.stereotype.Component;

import com.collabera.material.itemdto.ItemDto;
import com.collabera.material.model.Item;

@Component
public class ItemMapper {
	
	public Item toEntity(ItemDto dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setCost(dto.getCost());
        item.setNum(dto.getNumOfItems());
        item.setPicture(dto.getPicture());
        return item;
    }

    public ItemDto toDto(Item entity) {
    	ItemDto item = new ItemDto();
    	item.setId(entity.getId());
    	item.setName(entity.getName());
    	item.setCost(entity.getCost());
    	item.setNumOfItems(entity.getNum());
    	item.setPicture(entity.getPicture());
        return item;
    }

}
