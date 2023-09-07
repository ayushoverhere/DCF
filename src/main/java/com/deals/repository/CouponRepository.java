package com.deals.repository;

import com.deals.model.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CouponRepository extends MongoRepository<Coupon, String> {

    // Add custom query methods here if needed
}
