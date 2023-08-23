package com.devmandrik.inventoryservice.service;

import com.devmandrik.inventoryservice.dto.InventoryResponse;
import com.devmandrik.inventoryservice.mapper.InventoryMapper;
import com.devmandrik.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    private final InventoryMapper inventoryMapper = InventoryMapper.INSTANCE;

    @Transactional(readOnly = true)
    @SneakyThrows
    public boolean isInStock(String skuCode) {
        log.info("Checking Inventory");
        return inventoryRepository.findBySkuCode().isPresent();
    }
}
