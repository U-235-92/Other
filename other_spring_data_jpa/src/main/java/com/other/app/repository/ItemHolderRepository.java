package com.other.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.other.app.entity.ItemHolder;

public interface ItemHolderRepository extends JpaRepository<ItemHolder, Long> {

}
