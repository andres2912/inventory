package com.efitel.inventory.mapper.item;

import org.mapstruct.Mapper;

import com.efitel.inventory.mapper.CentralMappingConfig;
import com.efitel.inventory.models.dto.item.ItemDTO;
import com.efitel.inventory.models.entity.item.ItemEntity;

@Mapper(config = CentralMappingConfig.class)
public interface ItemMapper {
	ItemEntity toItemEntity(ItemDTO itemDTO);

	ItemDTO toItemDTO(ItemEntity itemEntity);

}
