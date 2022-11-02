package com.esteban.purchaseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esteban.purchaseservice.entity.Purchase;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}
