package com.jungeun.jpademo.repository;

import com.jungeun.jpademo.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
