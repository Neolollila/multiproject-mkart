package com.devmandrik.inventoryservice.mapper;

import com.devmandrik.inventoryservice.dto.InventoryResponse;
import com.devmandrik.inventoryservice.model.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMapper {

    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

//    @Mapping(source = "quantity", target = "isInStock")
    InventoryResponse inventoryToInventoryResponse(Inventory inventory);
}
