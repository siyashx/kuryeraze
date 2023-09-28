package com.kuryeraze.kuryeraze.dao.shop;

import com.kuryeraze.kuryeraze.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Shop findShopByEmail(String email);
    Shop findShopByUsername(String username);
}
