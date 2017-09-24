package com.craig.ubs.supermarket.core.repository;

import com.craig.ubs.supermarket.core.data.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity findBySku(String sku);
}
