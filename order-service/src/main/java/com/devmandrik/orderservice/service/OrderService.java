package com.devmandrik.orderservice.service;

import com.devmandrik.orderservice.dto.OrderRequest;
import com.devmandrik.orderservice.mapper.OrderLineItemsMapper;
import com.devmandrik.orderservice.model.Order;
import com.devmandrik.orderservice.model.OrderLineItems;
import com.devmandrik.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderLineItemsMapper productMapper = OrderLineItemsMapper.INSTANCE;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(productMapper::OrderLineItemsDtoToOrderLineItems)
                .toList();

        order.setOrderLineItemsList(orderLineItemsList);

        orderRepository.save(order);
    }
}
