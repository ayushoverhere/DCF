package com.deals.service;

import com.deals.model.Coupon;

import java.util.List;

public interface CouponService {

    void submitCoupon(Coupon coupon);

    List<Coupon> getAllCoupons();

    void updateCoupon(String couponCode, Coupon updatedCoupon);

    void deleteCoupon(String couponCode);

    long getTotalSubmissions();

    Coupon getCouponByCode(String couponCode);

	List<Coupon> getCouponsByMerchant(String merchantName);

}