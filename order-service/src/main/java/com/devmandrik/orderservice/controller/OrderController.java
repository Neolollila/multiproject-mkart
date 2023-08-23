package com.devmandrik.orderservice.controller;

import com.devmandrik.orderservice.dto.OrderRequest;
import com.devmandrik.orderservice.mapper.OrderLineItemsMapper;
import com.devmandrik.orderservice.model.Order;
import com.devmandrik.orderservice.model.OrderLineItems;
import com.devmandrik.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }

















}
