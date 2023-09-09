package com.deals.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deals.model.Coupon;

@Repository
public interface CouponRepository extends MongoRepository<Coupon, String> {
    List<Coupon> findByMerchantNameIgnoreCase(String merchantName);
}
