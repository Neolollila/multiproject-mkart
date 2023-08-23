package com.devmandrik.orderservice.mapper;

import com.devmandrik.orderservice.dto.OrderLineItemsDto;
import com.devmandrik.orderservice.model.OrderLineItems;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderLineItemsMapper {

    OrderLineItemsMapper INSTANCE = Mappers.getMapper(OrderLineItemsMapper.class);

    OrderLineItems OrderLineItemsDtoToOrderLineItems (OrderLineItemsDto orderLineItemsDto);
}
